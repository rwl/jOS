/**
 * Copyright (c) 2009-2010 Krueger Systems, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jos.samples.task.core.data;

import java.util.Collections;


public class SQLite {

    public static class SQLiteException extends Exception
    {
            public SQLite3.Result result;

            protected SQLiteException (SQLite3.Result r,string message)
            {
                super(message);
                result = r;
            }

            public static SQLiteException create(SQLite3.Result r, string message)
            {
                    return new SQLiteException (r, message);
            }
    }

    /**
     * Represents an open connection to a SQLite database.
     */
    public statci class SQLiteConnection
    {
            private boolean _open;
            private TimeSpan _busyTimeout;
            private Map<String, TableMapping> _mappings = null;
            private Map<String, TableMapping> _tables = null;
//            private System.Diagnostics.Stopwatch _sw;
            private long _elapsedMilliseconds = 0;

            public IntPtr handle;

            public String databasePath;

            public boolean timeExecution;

            public boolean trace;

            /**
             * Constructs a new SQLiteConnection and opens a SQLite database specified by databasePath.
             * @param databasePath Specifies the path to the database file.
             */
            public SQLiteConnection (String databasePath)
            {
                    this.databasePath = databasePath;
                    IntPtr handle;
                    Result r = SQLite3.open (databasePath, /*out */handle);
                    this.handle = handle;
                    if (r != SQLite3.Result.OK) {
                            throw SQLiteException.create(r, "Could not open database file: " + DatabasePath);
                    }
                    _open = true;

                    setBusyTimeout(TimeSpan.fromSeconds (0.1));
            }

            static SQLiteConnection ()
            {
                    if (_preserveDuringLinkMagic) {
                        TableInfo ti = new TableInfo ();
                        ti.setName("magic");
                    }
            }

            /**
             * Used to list some code that we want the MonoTouch linker
             * to see, but that we never want to actually execute.
             */
            static boolean _preserveDuringLinkMagic = false;

            /**
             * Sets a busy handler to sleep the specified amount of time when a table is locked.
             * The handler will sleep multiple times until a total time of <see cref="BusyTimeout"/> has accumulated.
             */
            private TimeSpan busyTimeout;

            public TimeSpan getBusyTimeout() {
                return _busyTimeout;
            }

            public void setBusyTimeout(TimeSpan value) {
                _busyTimeout = value;
                if (handle != IntPtr.Zero) {
                    SQLite3.busyTimeout (handle, (int) _busyTimeout.totalMilliseconds);
                }
            }

            /**
             * Returns the mappings from types to tables that the connection
             * currently understands.
             */
            private Iterable<TableMapping> tableMappings;

            public Iterable<TableMapping> getTableMappings() {
                            if (_tables == null) {
                                    return Collections.<TableMapping>emptyList();
                            } else {
                                    return _tables.values;
                            }
                    }
            }

            /**
             * Retrieves the mapping that is automatically generated for the given type.
             * @param type The type whose mapping to the database is returned.
             * @return The mapping represents the schema of the columns of the database and contains
             * methods to set and get properties of objects.
             */
            public TableMapping getMapping (Type type)
            {
                    if (_mappings == null) {
                            _mappings = new HashMap<String, TableMapping> ();
                    }
                    TableMapping map;
                    if (_mappings.get(type.FullName, out map) == null) {
                            map = new TableMapping (type);
                            _mappings.put(type.fullName, map);
                    }
                    return map;
            }

            /**
             * Executes a "create table if not exists" on the database. It also
             * creates any specified indexes on the columns of the table. It uses
             * a schema automatically generated from the specified type. You can
             * later access this schema by calling GetMapping.
             *
             * @retrun The number of entries added to the database schema.
             */
            public <T> int createTable ()
            {
                    T ty = typeof(T);

                    if (_tables == null) {
                            _tables = new HashMap<String, TableMapping> ();
                    }
                    TableMapping map;
                    if (_tables.get(ty.FullName, out map) == null) {
                            map = getMapping (ty);
                            _tables.put(ty.FullName, map);
                    }
                    String query = "create table \"" + map.tableName + "\"(\n";

                    List<String> decls = map.columns.select (/*p => */Orm.sqlDecl (p));
                    String decl = String.join (",\n", decls.toArray());
                    query += decl;
                    query += ")";

                    int count = 0;

                    try {
                            execute (query);
                            count = 1;
                    }
                    catch (SQLiteException) {
                    }

                    if (count == 0) {
                            // Table already exists, migrate it
                            migrateTable (map);
                    }

                    for (T p : map.columns) {
                        if (x.IsIndexed) {
                            String indexName = map.tableName + "_" + p.name;
                            String q = String.format ("create index if not exists \"%s\" on \"%s\"(\"%s\")", indexName, map.tableName, p.name);
                            count += execute (q);
                        }
                    }

                    return count;
            }

            class TableInfo
            {
                    public int cid;

                    public String name;

                    public String type;

                    public int notnull;

                    public String dflt_value;

                    public int pk;
            }

            void migrateTable (TableMapping map)
            {
                    String q = "pragma table_info(\"" + map.tableName + "\")";

                    List<TableInfo> existingCols = query(q);

                    List<TableMapping.Column> toBeAdded = new ArrayList<TableMapping.Column> ();

                    for (TableMapping.Column p : map.columns) {
                            boolean found = false;
                            for (TableInfo c in existingCols) {
                                    found = p.name == c.name;
                                    if (found) {
                                            break;
                                    }
                            }
                            if (!found) {
                                    toBeAdded.add(p);
                            }
                    }

                    for (TableMapping.Column p : toBeAdded) {
                            String addCol = "alter table \"" + map.tableName + "\" add column " + Orm.sqlDecl (p);
                            execute (addCol);
                    }
            }

            /**
             * Creates a new SQLiteCommand given the command text with arguments. Place a '?'
             * in the command text for each of the arguments.
             *
             * @param cmdText The fully escaped SQL.
             * @param args Arguments to substitute for the occurences of '?' in the command text.
             * @return A <see cref="SQLiteCommand"/>
             */
            public SQLiteCommand createCommand (String cmdText, Object[] ps)
            {
                    if (!_open) {
                            throw SQLiteException.create(SQLite3.Result.Error, "Cannot create commands from unopened database");
                    } else {
                        SQLiteCommand cmd = new SQLiteCommand (this);
                            cmd.commandText = cmdText;
                            for (Object o : ps) {
                                    cmd.bind (o);
                            }
                            return cmd;
                    }
            }

            /**
             * Creates a SQLiteCommand given the command text (SQL) with arguments. Place a '?'
             * in the command text for each of the arguments and then executes that command.
             * Use this method instead of Query when you don't expect rows back. Such cases include
             * INSERTs, UPDATEs, and DELETEs.
             * You can set the Trace or TimeExecution properties of the connection
             * to profile execution.
             *
             * @param query The fully escaped SQL.
             * @param args Arguments to substitute for the occurences of '?' in the query.
             * @return The number of rows modified in the database as a result of this execution.
             */
            public int execute (String query, Object[] args)
            {
                SQLiteCommand cmd = createCommand (query, args);

                    if (timeExecution) {
                            if (_sw == null) {
                                    _sw = new Stopwatch ();
                            }
                            _sw.reset ();
                            _sw.start ();
                    }

                    int r = cmd.executeNonQuery ();

                    if (TimeExecution) {
                            _sw.stop ();
                            _elapsedMilliseconds += _sw.ElapsedMilliseconds;
                            System.out.println("Finished in %f ms (%.1f s total)", _sw.elapsedMilliseconds, _elapsedMilliseconds / 1000.0);
                    }

                    return r;
            }

            /**
             * Creates a SQLiteCommand given the command text (SQL) with arguments. Place a '?'
             * in the command text for each of the arguments and then executes that command.
             * It returns each row of the result using the mapping automatically generated for
             * the given type.
             *
             * @param query The fully escaped SQL.
             * @param args Arguments to substitute for the occurences of '?' in the query.
             * @return An enumerable with one result for each row returned by the query.
             */
            public <T> List<T> query (String query, Object[] args) //where T : new()
            {
                SQLiteCommand cmd = createCommand (query, args);
                    return cmd.<T>executeQuery ();
            }

            /**
             * Creates a SQLiteCommand given the command text (SQL) with arguments. Place a '?'
             * in the command text for each of the arguments and then executes that command.
             * It returns each row of the result using the specified mapping. This function is
             * only used by libraries in order to query the database via introspection. It is
             * normally not used.
             *
             * @param map A <see cref="TableMapping"/> to use to convert the resulting rows
             * into objects.
             * @param query The fully escaped SQL.
             * @param args Arguments to substitute for the occurences of '?' in the query.
             * @return  An enumerable with one result for each row returned by the query.
             */
            public List<Object> query (TableMapping map, String query, Object[] args)
            {
                SQLiteCommand cmd = createCommand (query, args);
                    return cmd.executeQuery<object> (map);
            }

            /**
             * Returns a queryable interface to the table represented by the given type.
             *
             * @return A queryable object that is able to translate Where, OrderBy, and Take
             * queries into native SQL.
             */
            public <T> TableQuery<T> table()// where T : new()
            {
                    return new TableQuery<T>(this);
            }

            /**
             * Attempts to retrieve an object with the given primary key from the table
             * associated with the specified type. Use of this method requires that
             * the given type have a designated PrimaryKey (using the PrimaryKeyAttribute).
             *
             * @param pk The primary key.
             * @return The object with the given primary key. Throws a not found exception
             * if the object is not found.
             */
            public <T> T get(Object pk) //where T : new()
            {
                TableMapping map = getMapping (typeof(T));
                    String query = String.format ("select * from \"%s\" where \"%s\" = ?", map.tableName, map.PK.name);
                    return query<T>(query, pk).iterator().next();
            }

            /**
             * Whether <see cref="BeginTransaction"/> has been called and the database is waiting for a <see cref="Commit"/>.
             */
            public boolean isInTransaction;

            /**
             * Begins a new transaction. Call <see cref="Commit"/> to end the transaction.
             */
            public void beginTransaction ()
            {
                    if (!isInTransaction) {
                            execute ("begin transaction");
                            isInTransaction = true;
                    }
            }

            /**
             * Rolls back the transaction that was begun by <see cref="BeginTransaction"/>.
             */
            public void rollback ()
            {
                    if (isInTransaction) {
                            execute ("rollback");
                            isInTransaction = false;
                    }
            }

            /**
             * Commits the transaction that was begun by <see cref="BeginTransaction"/>.
             */
            public void commit ()
            {
                    if (isInTransaction) {
                            execute ("commit");
                            isInTransaction = false;
                    }
            }

            /**
             * Executes <param name="action"> within a transaction and automatically rollsback the transaction
             * if an exception occurs. The exception is rethrown.
             *
             * @param action The <see cref="Action"/> to perform within a transaction. <param name="action"> can contain any number
             * of operations on the connection but should never call <see cref="BeginTransaction"/>,
             * <see cref="Rollback"/>, or <see cref="Commit"/>.
             */
            public void runInTransaction (Action action)
            {
                    if (isInTransaction) {
                            throw new InvalidOperationException ("The connection must not already be in a transaction when RunInTransaction is called");
                    }
                    try {
                            beginTransaction ();
                            action ();
                            commit ();
                    } catch (Exception) {
                            rollback ();
                            throw;
                    }
            }

            /**
             * Inserts all specified objects.
             *
             * @param objects An <see cref="IEnumerable"/> of the objects to insert.
             * </param>
             * @returns The number of rows added to the table.
             */
            public int insertAll (Iterable objects)
            {
                    beginTransaction ();
                    int c = 0;
                    for (Object r : objects) {
                            c += insert (r);
                    }
                    commit ();
                    return c;
            }

            /**
             * Inserts the given object and retrieves its
             * auto incremented primary key if it has one.
             *
             * @param obj The object to insert.
             * @return The number of rows added to the table.
             */
            public int insert (Object obj)
            {
                    if (obj == null) {
                            return 0;
                    }
                    return insert (obj, "", obj.getType ());
            }

            public int insert (Object obj, Type objType)
            {
                    return insert (obj, "", objType);
            }

            public int insert (Object obj, String extra)
            {
                    if (obj == null) {
                            return 0;
                    }
                    return insert (obj, extra, obj.getType ());
            }

            /**
             * Inserts the given object and retrieves its
             * auto incremented primary key if it has one.
             *
             * @param obj The object to insert.
             * @param extra Literal SQL code that gets placed into the command. INSERT {extra} INTO ...
             * @return The number of rows added to the table.
             */
            public int insert (Object obj, String extra, Type objType)
            {
                    if (obj == null || objType == null) {
                            return 0;
                    }

                    var map = getMapping (objType);

                    List cols = map.insertColumns;
                    List vals = new Object[cols.size()];
                    for (var i = 0; i < vals.length; i++) {
                            vals [i] = cols.get(i).getValue (obj);
                    }

                    SQLiteCommand insertCmd = map.getInsertCommand (this, extra);
                    int count = insertCmd.executeNonQuery (vals);

                    if (map.hasAutoIncPK) {
                            int id = SQLite3.lastInsertRowid (Handle);
                            map.setAutoIncPK (obj, id);
                    }

                    return count;
            }

            /**
             * Updates all of the columns of a table using the specified object
             * except for its primary key.
             * The object is required to have a primary key.
             *
             * @param obj The object to update. It must have a primary key designated using the PrimaryKeyAttribute.
             * @return  The number of rows updated.
             */
            public int update (Object obj)
            {
                    if (obj == null) {
                            return 0;
                    }
                    return update (obj, obj.getType ());
            }

            public int update (Object obj, Type objType)
            {
                    if (obj == null || objType == null) {
                            return 0;
                    }

                    TableMapping map = getMapping (objType);

                    Column pk = map.PK;

                    if (pk == null) {
                            throw new NotSupportedException ("Cannot update " + map.TableName + ": it has no PK");
                    }

                    List<Column> cols;// = from p in map.Columns where p != pk select p;
                    List vals;// = from c in cols select c.GetValue (obj);
                    List<Object> ps = new ArrayList<Object> (vals);
                    ps.add (pk.getValue (obj));
                    String q;// = String.format ("update \"%s\" set %s where %s = ? ", map.tableName, String.join (",", (from c in cols select "\"" + c.Name + "\" = ? ").ToArray ()), pk.Name);
                    return execute (q, ps.toArray ());
            }

            /**
             * Deletes the given object from the database using its primary key.
             *
             * @param obj The object to delete. It must have a primary key designated using the PrimaryKeyAttribute.
             * @return The number of rows deleted.
             */
            public <T> int delete (T obj)
            {
                    TableMapping map = getMapping (obj.getType ());
                    Column pk = map.PK;
                    if (pk == null) {
                            throw new NotSupportedException ("Cannot delete " + map.tableName + ": it has no PK");
                    }
                    String q = String.format ("delete from \"%s\" where \"%s\" = ?", map.tableName, pk.name);
                    return execute (q, pk.getValue (obj));
            }

            public void dispose ()
            {
                    close ();
            }

            public void close ()
            {
                    if (_open && handle != IntPtr.Zero) {
                            SQLite3.close (handle);
                            handle = IntPtr.Zero;
                            _open = false;
                    }
            }
    }
/*
    public @interface PrimaryKeyAttribute
    {
    }

    public @interface AutoIncrementAttribute
    {
    }

    public @interface IndexedAttribute
    {
    }

    public @interface IgnoreAttribute
    {
    }

    public @interface MaxLengthAttribute
    {
            int value();
    }

    public @interface CollationAttribute
    {
            String value();
    }
*/
    public class TableMapping
    {
            public Type mappedType ;

            public String tableName;

            public Column[] columns ;

            public Column PK;

            Column _autoPk = null;
            Column[] _insertColumns = null;
            string _insertSql = null;

            public TableMapping (Type type)
            {
                    mappedType = type;
                    tableName = mappedType.name;
                    var props = mappedType.getProperties(BindingFlags.Public | BindingFlags.Instance | BindingFlags.SetProperty);
                    var cols = new ArrayList<Column> ();
                    for (var p : props) {
                            boolean ignore = p.getCustomAttributes (typeof(IgnoreAttribute), true).length > 0;
                            if (p.canWrite && !ignore) {
                                    cols.add (new PropColumn (p));
                            }
                    }
                    columns = cols.toArray ();
                    for (Column c : Columns) {
                            if (c.isAutoInc && c.isPK) {
                                    _autoPk = c;
                            }
                            if (c.isPK) {
                                    PK = c;
                            }
                    }

                    hasAutoIncPK = _autoPk != null;
            }

            public boolean hasAutoIncPK;

            public void setAutoIncPK (Object obj, long id)
            {
                    if (_autoPk != null) {
                            _autoPk.setValue (obj, Convert.changeType (id, _autoPk.ColumnType));
                    }
            }

            public Column[] getInsertColumns() {
                            if (_insertColumns == null) {
                                    _insertColumns = columns;//.Where (c => !c.IsAutoInc).ToArray ();
                            }
                            return _insertColumns;
                    }
            }

            public Column findColumn (String name)
            {
                    Column exact = columns;//.Where (c => c.Name == name).FirstOrDefault ();
                    return exact;
            }

            public String insertSql (String extra)
            {
                    if (_insertSql == null) {
                        Column[] cols = getInsertColumns();
                            //_insertSql = String.format ("insert %s into \"%s\"(%s) values (%s)", extra, tableName, String.join (",", (from c in cols select "\"" + c.Name + "\"").ToArray ()), string.Join (",", (from c in cols select "?").ToArray ()));
                    }
                    return _insertSql;
            }

            PreparedSqlLiteInsertCommand _insertCommand;
            String _insertCommandExtra = null;

            public PreparedSqlLiteInsertCommand getInsertCommand (SQLiteConnection conn, string extra)
            {
                    if (_insertCommand == null || _insertCommandExtra != extra) {
                            String insertSql = insertSql (extra);
                            _insertCommand = new PreparedSqlLiteInsertCommand (conn);
                            _insertCommand.commandText = insertSql;
                            _insertCommandExtra = extra;
                    }
                    return _insertCommand;
            }

            public static abstract class Column
            {
                    public String name;

                    public Type columnType;

                    public String collation;

                    public boolean isAutoInc;

                    public boolean isPK;

                    public boolean isIndexed;

                    public boolean isNullable;

                    public int maxStringLength;

                    public abstract void setValue (Object obj, Object val);

                    public abstract Object getValue (Object obj);
            }

            public static class PropColumn extends Column
            {
                    PropertyInfo _prop;

                    public PropColumn (PropertyInfo prop)
                    {
                            _prop = prop;
                            Name = prop.name;
                            //If this type is Nullable<T> then Nullable.GetUnderlyingType returns the T, otherwise it returns null, so get the the actual type instead
//                            columnType = Nullable.getUnderlyingType(prop.PropertyType) ?? prop.PropertyType;
                            collation = Orm.collation (prop);
                            isAutoInc = Orm.isAutoInc (prop);
                            isPK = Orm.isPK (prop);
                            isIndexed = Orm.isIndexed (prop);
                            isNullable = !isPK;
                            maxStringLength = Orm.maxStringLength (prop);
                    }

                    @Override
                    public void setValue (Object obj, Object val)
                    {
                            _prop.setValue (obj, val, null);
                    }

                    @Override
                    public Object getValue (Object obj)
                    {
                            return _prop.getValue (obj, null);
                    }
            }
    }

    public static class Orm
    {
            public final int DefaultMaxStringLength = 140;

            public static String sqlDecl (TableMapping.Column p)
            {
                    String decl = "\"" + p.name + "\" " + sqlType (p) + " ";

                    if (p.isPK) {
                            decl += "primary key ";
                    }
                    if (p.isAutoInc) {
                            decl += "autoincrement ";
                    }
                    if (!p.isNullable) {
                            decl += "not null ";
                    }
                    if (!String.isNullOrEmpty (p.collation)) {
                            decl += "collate " + p.collation + " ";
                    }

                    return decl;
            }

            public static String sqlType (TableMapping.Column p)
            {
                    Type clrType = p.columnType;
                    if (clrType == typeof(Boolean) || clrType == typeof(Byte) || clrType == typeof(UInt16) || clrType == typeof(SByte) || clrType == typeof(Int16) || clrType == typeof(Int32)) {
                            return "integer";
                    } else if (clrType == typeof(UInt32) || clrType == typeof(Int64)) {
                            return "bigint";
                    } else if (clrType == typeof(Single) || clrType == typeof(Double) || clrType == typeof(Decimal)) {
                            return "float";
                    } else if (clrType == typeof(String)) {
                            int len = p.maxStringLength;
                            return "varchar(" + len + ")";
                    } else if (clrType == typeof(DateTime)) {
                            return "datetime";
                    } else if (clrType.isEnum) {
                            return "integer";
                    } else if (clrType == typeof(byte[])) {
                            return "blob";
                    } else {
                            throw new NotSupportedException ("Don't know about " + clrType);
                    }
            }

            public static boolean isPK (MemberInfo p)
            {
                    var attrs = p.getCustomAttributes (typeof(PrimaryKeyAttribute), true);
                    return attrs.length > 0;
            }

            public static String collation (MemberInfo p)
            {
                    var attrs = p.getCustomAttributes (typeof(CollationAttribute), true);
                    if (attrs.length > 0) {
                            return ((CollationAttribute)attrs [0]).value;
                    } else {
                            return String.empty();
                    }
            }

            public static boolean isAutoInc (MemberInfo p)
            {
                    var attrs = p.getCustomAttributes (typeof(AutoIncrementAttribute), true);
                    return attrs.length > 0;
            }

            public static boolean isIndexed (MemberInfo p)
            {
                    var attrs = p.getCustomAttributes (typeof(IndexedAttribute), true);
                    return attrs.length > 0;
            }

            public static int maxStringLength (PropertyInfo p)
            {
                    var attrs = p.getCustomAttributes (typeof(MaxLengthAttribute), true);
                    if (attrs.length > 0) {
                            return ((MaxLengthAttribute)attrs [0]).value;
                    } else {
                            return DefaultMaxStringLength;
                    }
            }

    }

    public statci class SQLiteCommand
    {
            SQLiteConnection _conn;
            private List<Binding> _bindings;

            public String commandText;

            private /*internal */SQLiteCommand (SQLiteConnection conn)
            {
                    _conn = conn;
                    _bindings = new ArrayList<Binding> ();
                    commandText = "";
            }

            public int executeNonQuery ()
            {
                    if (_conn.trace) {
                            System.out.println("Executing: " + this);
                    }

                    Result r = SQLite3.Result.OK;
                    var stmt = prepare ();
                    r = SQLite3.step (stmt);
                    finalize (stmt);
                    if (r == SQLite3.Result.Done) {
                            int rowsAffected = SQLite3.changes (_conn.handle);
                            return rowsAffected;
                    } else if (r == SQLite3.Result.Error) {
                            String msg = SQLite3.getErrmsg (_conn.handle);
                            throw SQLiteException.create(r, msg);
                    } else {
                            throw SQLiteException.create(r, r.toString ());
                    }
            }

            public <T> List<T> executeQuery () //where T : new()
            {
                    return ExecuteQuery<T> (_conn.getMapping (typeof(T)));
            }

            public <T> List<T> ExecuteQuery(TableMapping map)
            {
                    if (_conn.trace) {
                            System.out.println("Executing Query: " + this);
                    }

                    List<T> r = new ArrayList<T> ();

                    var stmt = prepare ();

                    Column[] cols = new Column[SQLite3.columnCount (stmt)];

                    for (int i = 0; i < cols.Length; i++) {
                            String name = Marshal.ptrToStringUni (SQLite3.columnName16 (stmt, i));
                            cols [i] = map.findColumn (name);
                    }

                    while (SQLite3.step (stmt) == SQLite3.Result.Row) {
                            var obj = Activator.createInstance (map.mappedType);
                            for (int i = 0; i < cols.length; i++) {
                                    if (cols [i] == null) {
                                            continue;
                                    }
                                    ColumnType colType = SQLite3.ColumnType (stmt, i);
                                    var val = readCol (stmt, i, colType, cols [i].columnType);
                                    cols [i].setValue (obj, val);
                            }
                            r.add((T) obj);
                    }

                    finalize (stmt);
                    return r;
            }

            public <T> T executeScalar()
            {
                    if (_conn.trace) {
                            System.out.println("Executing Query: " + this);
                    }

                    T val;// = default(T);

                    var stmt = prepare ();
                    if (SQLite3.step (stmt) == SQLite3.Result.Row) {
                            Type colType = SQLite3.columnType (stmt, 0);
                            val = (T) readCol(stmt, 0, colType, typeof(T));
                    }
                    finalize (stmt);

                    return val;
            }

            public void bind (String name, Object val)
            {
                    _bindings.add (new Binding(name, val));
            }

            public void bind (Object val)
            {
                    bind (null, val);
            }

            @Override
            public String toString ()
            {
                String[] parts = new String[1 + _bindings.Count];
                    parts [0] = commandText;
                    int i = 1;
                    for (Binding b : _bindings) {
                            parts [i] = String.format ("  %d: %s", i - 1, b.value);
                            i++;
                    }
                    return String.join(Environment.newLine, parts);
            }

            IntPtr prepare ()
            {
                IntPtr stmt = SQLite3.prepare2 (_conn.handle, commandText);
                    bindAll (stmt);
                    return stmt;
            }

            void finalize (IntPtr stmt)
            {
                    SQLite3.finalize (stmt);
            }

            void bindAll (IntPtr stmt)
            {
                    int nextIdx = 1;
                    for (Binding b : _bindings) {
                            if (b.name != null) {
                                    b.index = SQLite3.bindParameterIndex (stmt, b.name);
                            } else {
                                    b.index = nextIdx++;
                            }
                    }
                    for (Binding b : _bindings) {
                            bindParameter (stmt, b.Index, b.Value);
                    }
            }

            private /*internal */static IntPtr negativePointer = new IntPtr (-1);

            private /*internal */static void bindParameter (IntPtr stmt, int index, object value)
            {
                    if (value == null) {
                            SQLite3.bindNull (stmt, index);
                    } else {
                            if (value == Int32) {
                                    SQLite3.bindInt (stmt, index, (int)value);
                            } else if (value == String) {
                                    SQLite3.bindText (stmt, index, (string)value, -1, NegativePointer);
                            } else if (value == Byte || value == UInt16 || value == SByte || value == Int16) {
                                    SQLite3.bindInt (stmt, index, Convert.toInt32 (value));
                            } else if (value == Boolean) {
                                    SQLite3.bindInt (stmt, index, (boolean) value ? 1 : 0);
                            } else if (value == UInt32 || value == Int64) {
                                    SQLite3.bindInt64 (stmt, index, Convert.toInt64 (value));
                            } else if (value == Single || value == Double || value == Decimal) {
                                    SQLite3.bindDouble (stmt, index, Convert.toDouble (value));
                            } else if (value == DateTime) {
                                    SQLite3.bindText (stmt, index, ((DateTime) value).toString ("yyyy-MM-dd HH:mm:ss"), -1, negativePointer);
                            } else if (value.getType ().isEnum) {
                                    SQLite3.bindInt (stmt, index, Convert.toInt32 (value));
                            } else if (value == byte[]) {
                                    SQLite3.bindBlob (stmt, index, (byte[]) value, ((byte[]) value).Length, negativePointer);
                            } else {
                                    throw new NotSupportedException ("Cannot store type: " + value.getType ());
                            }
                    }
            }

            class Binding
            {
                    public String name;

                    public Object value ;

                    public int index;
            }

            Object readCol (IntPtr stmt, int index, SQLite3.ColType type, Type clrType)
            {
                    if (type == SQLite3.ColType.Null) {
                            return null;
                    } else {
                            if (clrType == typeof(String)) {
                                    return SQLite3.columnString (stmt, index);
                            } else if (clrType == typeof(Int32)) {
                                    return (int)SQLite3.columnInt (stmt, index);
                            } else if (clrType == typeof(Boolean)) {
                                    return SQLite3.columnInt (stmt, index) == 1;
                            } else if (clrType == typeof(double)) {
                                    return SQLite3.columnDouble (stmt, index);
                            } else if (clrType == typeof(float)) {
                                    return (float)SQLite3.columnDouble (stmt, index);
                            } else if (clrType == typeof(DateTime)) {
                                    var text = SQLite3.columnString (stmt, index);
                                    return DateTime.parse (text);
                            } else if (clrType.IsEnum) {
                                    return SQLite3.columnInt (stmt, index);
                            } else if (clrType == typeof(Int64)) {
                                    return SQLite3.columnInt64 (stmt, index);
                            } else if (clrType == typeof(UInt32)) {
                                    return (uint)SQLite3.columnInt64 (stmt, index);
                            } else if (clrType == typeof(decimal)) {
                                    return (decimal)SQLite3.columnDouble (stmt, index);
                            } else if (clrType == typeof(Byte)) {
                                    return (byte)SQLite3.columnInt (stmt, index);
                            } else if (clrType == typeof(UInt16)) {
                                    return (ushort)SQLite3.columnInt (stmt, index);
                            } else if (clrType == typeof(Int16)) {
                                    return (short)SQLite3.columnInt (stmt, index);
                            } else if (clrType == typeof(sbyte)) {
                                    return (sbyte)SQLite3.columnInt (stmt, index);
                            } else if (clrType == typeof(byte[])) {
                                    return SQLite3.columnByteArray (stmt, index);
                            } else {
                                    throw new NotSupportedException ("Don't know how to read " + clrType);
                            }
                    }
            }
    }

    /**
     * Since the insert never changed, we only need to prepare once.
     */
    public static class PreparedSqlLiteInsertCommand  // implements IDisposable
    {
            public boolean initialized;

            protected SQLiteConnection connection;

            public String commandText;

            protected IntPtr statement;

            private /*internal */PreparedSqlLiteInsertCommand (SQLiteConnection conn)
            {
                    connection = conn;
            }

            public int executeNonQuery (Object[] source)
            {
                    if (connection.trace) {
                            System.out.println("Executing: " + commandText);
                    }

                    Result r = SQLite3.Result.OK;

                    if (!initialized) {
                            statement = prepare ();
                            initialized = true;
                    }

                    // bind the values.
                    if (source != null) {
                            for (int i = 0; i < source.length; i++) {
                                    SQLiteCommand.bindParameter (statement, i + 1, source [i]);
                            }
                    }
                    r = SQLite3.step (statement);

                    if (r == SQLite3.Result.Done) {
                            int rowsAffected = SQLite3.changes (connection.handle);
                            SQLite3.reset (statement);
                            return rowsAffected;
                    } else if (r == SQLite3.Result.Error) {
                            String msg = SQLite3.getErrmsg (connection.handle);
                            SQLite3.reset (Statement);
                            throw SQLiteException.create(r, msg);
                    } else {
                            SQLite3.reset (Statement);
                            throw SQLiteException.create(r, r.ToString ());
                    }
            }

            protected /*virtual */IntPtr prepare ()
            {
                    IntPtr stmt = SQLite3.prepare2 (connection.handle, commandText);
                    return stmt;
            }

            public void dispose ()
            {
                    dispose (true);
                    GC.suppressFinalize (this);
            }

            private void dispose (boolean disposing)
            {
                    if (statement != IntPtr.Zero) {
                            try {
                                    SQLite3.finalize (statement);
                            } finally {
                                    statement = IntPtr.Zero;
                                    connection = null;
                            }
                    }
            }

            /*~*/preparedSqlLiteInsertCommand ()
            {
                    dispose (false);
            }
    }

    public static class TableQuery<T> implements Iterable//: IEnumerable<T> where T : new()
    {
            public SQLiteConnection connection;

            public TableMapping table;

            Expression _where;
            List<Ordering> _orderBys;
            int/*?*/ _limit;
            int/*?*/ _offset;

            class Ordering
            {
                    public String columnName;

                    public boolean ascending;
            }

            TableQuery (SQLiteConnection conn, TableMapping table)
            {
                    connection = conn;
                    table = table;
            }

            public TableQuery (SQLiteConnection conn)
            {
                    connection = conn;
                    table = connection.getMapping (typeof(T));
            }

            public TableQuery<T> clone ()
            {
                TableQuery<T> q = new TableQuery<T> (connection, table);
                    q._where = _where;
                    if (_orderBys != null) {
                            q._orderBys = new ArrayList<Ordering> (_orderBys);
                    }
                    q._limit = _limit;
                    q._offset = _offset;
                    return q;
            }

            public TableQuery<T> where(Expression<Func<T, Boolean>> predExpr)
            {
                    if (predExpr.NodeType == ExpressionType.Lambda) {
                        LambdaExpression lambda = (LambdaExpression)predExpr;
                            var pred = lambda.body;
                            var q = clone ();
                            q.addWhere (pred);
                            return q;
                    } else {
                            throw new NotSupportedException ("Must be a predicate");
                    }
            }

            public TableQuery<T> take (int n)
            {
                    var q = clone ();
                    q._limit = n;
                    return q;
            }

            public TableQuery<T> skip (int n)
            {
                    var q = clone ();
                    q._offset = n;
                    return q;
            }

            public <U> TableQuery<T> orderBy(Expression<Func<T, U>> orderExpr)
            {
                    return addOrderBy<U> (orderExpr, true);
            }

            public TableQuery<T> orderByDescending<U> (Expression<Func<T, U>> orderExpr)
            {
                    return addOrderBy<U> (orderExpr, false);
            }

            private <U> TableQuery<T> addOrderBy (Expression<Func<T, U>> orderExpr, boolean asc)
            {
                    if (orderExpr.nodeType == ExpressionType.Lambda) {
                        LambdaExpression lambda = (LambdaExpression) orderExpr;
                        MemberExpression mem = (MemberExpression) lambda.body;
                            if (mem != null && (mem.expression.nodeType == ExpressionType.parameter)) {
                                    var q = clone ();
                                    if (q._orderBys == null) {
                                            q._orderBys = new ArrayList<Ordering> ();
                                    }
                                    q._orderBys.add (new Ordering(/*columnName*/ mem.Member.Name,
                                            /*ascending*/ asc));
                                    return q;
                            } else {
                                    throw new NotSupportedException ("Order By does not support: " + orderExpr);
                            }
                    } else {
                            throw new NotSupportedException ("Must be a predicate");
                    }
            }

            private void addWhere (Expression pred)
            {
                    if (_where == null) {
                            _where = pred;
                    } else {
                            _where = Expression.andAlso (_where, pred);
                    }
            }

            private SQLiteCommand generateCommand (String selectionList)
            {
                    String cmdText = "select " + selectionList + " from \"" + Table.tableName + "\"";
                    List<Object> args = new ArrayList<Object> ();
                    if (_where != null) {
                            var w = compileExpr (_where, args);
                            cmdText += " where " + w.commandText;
                    }
                    if ((_orderBys != null) && (_orderBys.size() > 0)) {
                            String t;// = String.join (", ", _orderBys.Select (o => "\"" + o.ColumnName + "\"" + (o.Ascending ? "" : " desc")).ToArray ());
                            cmdText += " order by " + t;
                    }
                    if (_limit.hasValue) {
                            cmdText += " limit " + _limit.value;
                    }
                    if (_offset.hasValue) {
                            if (!_limit.hasValue) {
                                    cmdText += " limit -1 ";
                            }
                            cmdText += " offset " + _offset.value;
                    }
                    return Connection.createCommand (cmdText, args.toArray ());
            }

            class static CompileResult
            {
                    public String commandText;

                    public Object value;
            }

            private CompileResult compileExpr(Expression expr, List<Object> queryArgs)
            {
                    if (expr == null) {
                            throw new NotSupportedException ("Expression is NULL");
                    } else if (expr == BinaryExpression) {
                        BinaryExpression bin = (BinaryExpression) expr;

                            var leftr = compileExpr (bin.left, queryArgs);
                            var rightr = compileExpr (bin.right, queryArgs);

                            // If either side is a parameter and is null, then handle the other side specially (for "is null"/"is not null")
                            String text;
                            if (leftr.commandText == "?" && leftr.value == null) {
                                    text = compileNullBinaryExpression(bin, rightr);
                            } else if (rightr.commandText == "?" && rightr.value == null) {
                                    text = compileNullBinaryExpression(bin, leftr);
                            } else {
                                    text = "(" + leftr.commandText + " " + getSqlName(bin) + " " + rightr.commandText + ")";
                            }
                            return new CompileResult(/*commandText*/ text);
                    } else if (expr.nodeType == ExpressionType.call) {

                        MethodCallExpression call = (MethodCallExpression) expr;
                        CompileResult[] args = new CompileResult[call.arguments.size()];

                            for (var i = 0; i < args.length; i++) {
                                    args [i] = compileExpr (call.arguments [i], queryArgs);
                            }

                            String sqlCall = "";

                            if (call.method.name.equals("Like") && args.length == 2) {
                                    sqlCall = "(" + args[0].commandText + " like " + args[1].commandText + ")";
                            } else if (call.method.name.equals("Contains") && args.length == 2) {
                                    sqlCall = "(" + args[1].commandText + " in " + args[0].commandText + ")";
                            } else {
//                                    sqlCall = call.method.name.toLower() + "(" + String.join (",", args.Select (a => a.CommandText).ToArray ()) + ")";
                            }
                            return new CompileResult(/*CommandText*/ sqlCall);

                    } else if (expr.NodeType == ExpressionType.Constant) {
                        ConstantExpression c = (ConstantExpression) expr;
                            queryArgs.add (c.value);
                            return new CompileResult(/*commandText*/ "?", /*value*/ c.value);
                    } else if (expr.NodeType == ExpressionType.Convert) {
                        UnaryExpression u = (UnaryExpression) expr;
                            var ty = u.type;
                            var valr = compileExpr (u.operand, queryArgs);
                            return new CompileResult(/*commandText*/ valr.commandText,
                                    /*value*/ valr.value != null ? Convert.changeType(valr.Value, ty) : null);
                    } else if (expr.nodeType == ExpressionType.MemberAccess) {
                        MemberExpression mem = (MemberExpression) expr;

                            if (mem.expression.nodeType == ExpressionType.parameter) {
                                    //
                                    // This is a column of our table, output just the column name
                                    //
                                    return new CompileResult(/*commandText*/ "\"" + mem.member.name + "\"" };
                            } else {
                                    Object obj = null;
                                    if (mem.expression != null) {
                                            var r = compileExpr(mem.expression, queryArgs);
                                            if (r.value == null) {
                                                    throw new NotSupportedException ("Member access failed to compile expression");
                                            }
                                            if (r.commandText.equals("?")) {
                                                    queryArgs.removeAt(queryArgs.size() - 1);
                                            }
                                            obj = r.value;
                                    }

                                    //
                                    // Get the member value
                                    //
                                    Object val = null;

                                    if (mem.member.memberType == MemberTypes.Property) {
                                        PropertyInfo m = (PropertyInfo) mem.member;
                                            val = m.getValue (obj, null);
                                    } else if (mem.member.memberType == MemberTypes.Field) {
                                        FieldInfo m = (FieldInfo) mem.member;
                                            val = m.getValue (obj);
                                    } else {
                                            throw new NotSupportedException ("MemberExpr: " + mem.member.memberType.toString ());
                                    }

                                    //
                                    // Work special magic for enumerables
                                    //
                                    if (val != null && val == Iterable && !(val == String.class)) {
                                        StringBuilder sb = new StringBuilder();
                                            sb.append("(");
                                            string head = "";
                                            for (var a : (Iterable) val) {
                                                    queryArgs.add(a);
                                                    sb.append(head);
                                                    sb.append("?");
                                                    head = ",";
                                            }
                                            sb.append(")");
                                            return new CompileResult(/*commandText*/ sb.toString(), /*value*/ val);
                                    }
                                    else {
                                            queryArgs.add (val);
                                            return new CompileResult(/*commandText*/ "?", /*value*/ val);
                                    }
                            }
                    }
                    throw new NotSupportedException ("Cannot compile: " + expr.nodeType.toString ());
            }

            /**
             * Compiles a BinaryExpression where one of the parameters is null.
             * @param expression
             * @param parameter The non-null parameter
             * @return
             */
            private String compileNullBinaryExpression(BinaryExpression expression, CompileResult parameter)
            {
                    if (expression.nodeType == ExpressionType.Equal) {
                            return "(" + parameter.commandText + " is ?)";
                    } else if (expression.nodeType == ExpressionType.NotEqual) {
                            return "(" + parameter.commandText + " is not ?)";
                    } else {
                            throw new NotSupportedException("Cannot compile Null-BinaryExpression with type " + expression.nodeType.toString());
                    }
            }

            String getSqlName (Expression expr)
            {
                    var n = expr.nodeType;
                    if (n == ExpressionType.GreaterThan) {
                            return ">";
                    } else if (n == ExpressionType.GreaterThanOrEqual) {
                            return ">=";
                    } else if (n == ExpressionType.LessThan) {
                            return "<";
                    } else if (n == ExpressionType.LessThanOrEqual) {
                            return "<=";
                    } else if (n == ExpressionType.And) {
                            return "and";
                    } else if (n == ExpressionType.AndAlso) {
                            return "and";
                    } else if (n == ExpressionType.Or) {
                            return "or";
                    } else if (n == ExpressionType.OrElse) {
                            return "or";
                    } else if (n == ExpressionType.Equal) {
                            return "=";
                    } else if (n == ExpressionType.NotEqual) {
                            return "!=";
                    } else {
                            throw new System.NotSupportedException ("Cannot get SQL for: " + n.ToString ());
                    }
            }

            public int count ()
            {
                    return generateCommand("count(*)").executeScalar<int> ();
            }

            public Iterable<T> getEnumerator ()
            {
                    return generateCommand ("*").executeQuery<T> ().getEnumerator ();
            }

            Iterable Iterable.getIterable()
            {
                    return getIterable();
            }
    }

    public static class SQLite3
    {
            public enum Result //: int
            {
                    OK (0),
                    Error (1),
                    Internal (2),
                    Perm (3),
                    Abort (4),
                    Busy (5),
                    Locked (6),
                    NoMem (7),
                    ReadOnly (8),
                    Interrupt (9),
                    IOError (10),
                    Corrupt (11),
                    NotFound (12),
                    TooBig (18),
                    Constraint (19),
                    Row (100),
                    Done (101);

                    private final int code;

                    private Result(int code) {
                        this.code = code;
                    }

                    public int code() {
                        return this.code;
                    }
            }

            public enum ConfigOption : int
            {
                    SingleThread (1),
                    MultiThread (2),
                    Serialized (3);

                    private final int code;

                    private ConfigOption(int code) {
                        this.code = code;
                    }

                    public int code() {
                        return this.code;
                    }
            }

            @DllImport("sqlite3", EntryPoint = "sqlite3_open")
            public static native Result open (string filename, out IntPtr db);

            @DllImport("sqlite3", EntryPoint = "sqlite3_close")
            public static native Result close (IntPtr db);

            @DllImport("sqlite3", EntryPoint = "sqlite3_config")
            public static native Result config (ConfigOption option);

            @DllImport("sqlite3", EntryPoint = "sqlite3_busy_timeout")
            public static native Result busyTimeout (IntPtr db, int milliseconds);

            @DllImport("sqlite3", EntryPoint = "sqlite3_changes")
            public static native int changes (IntPtr db);

            @DllImport("sqlite3", EntryPoint = "sqlite3_prepare_v2")
            public static native Result prepare2 (IntPtr db, string sql, int numBytes, out IntPtr stmt, IntPtr pzTail);

            public static IntPtr prepare2 (IntPtr db, string query)
            {
                    IntPtr stmt;
                    Result r = prepare2 (db, query, query.Length, out stmt, IntPtr.Zero);
                    if (r != Result.OK) {
                            throw SQLiteException.create(r, getErrmsg (db));
                    }
                    return stmt;
            }

            @DllImport("sqlite3", EntryPoint = "sqlite3_step")
            public static native Result step (IntPtr stmt);

            @DllImport("sqlite3", EntryPoint = "sqlite3_reset")
            public static native Result reset (IntPtr stmt);

            @DllImport("sqlite3", EntryPoint = "sqlite3_finalize")
            public static native Result finalize (IntPtr stmt);

            @DllImport("sqlite3", EntryPoint = "sqlite3_last_insert_rowid")
            public static native long lastInsertRowid (IntPtr db);

            @DllImport("sqlite3", EntryPoint = "sqlite3_errmsg16")
            public static native IntPtr errmsg (IntPtr db);

            public static String getErrmsg (IntPtr db)
            {
                    return Marshal.ptrToStringUni (errmsg (db));
            }

            @DllImport("sqlite3", EntryPoint = "sqlite3_bind_parameter_index")
            public static native int bindParameterIndex (IntPtr stmt, string name);

            @DllImport("sqlite3", EntryPoint = "sqlite3_bind_null")
            public static native int bindNull (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_bind_int")
            public static native int bindInt (IntPtr stmt, int index, int val);

            @DllImport("sqlite3", EntryPoint = "sqlite3_bind_int64")
            public static native int bindInt64 (IntPtr stmt, int index, long val);

            @DllImport("sqlite3", EntryPoint = "sqlite3_bind_double")
            public static native int bindDouble (IntPtr stmt, int index, double val);

            @DllImport("sqlite3", EntryPoint = "sqlite3_bind_text")
            public static native int bindText (IntPtr stmt, int index, string val, int n, IntPtr free);

            @DllImport("sqlite3", EntryPoint = "sqlite3_bind_blob")
            public static native int bindBlob (IntPtr stmt, int index, byte[] val, int n, IntPtr free);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_count")
            public static native int columnCount (IntPtr stmt);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_name")
            public static native IntPtr columnName (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_name16")
            public static native IntPtr columnName16 (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_type")
            public static native ColType columnType (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_int")
            public static native int columnInt (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_int64")
            public static native long columnInt64 (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_double")
            public static native double columnDouble (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_text")
            public static native IntPtr columnText (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_text16")
            public static native IntPtr columnText16 (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_blob")
            public static native IntPtr columnBlob (IntPtr stmt, int index);

            @DllImport("sqlite3", EntryPoint = "sqlite3_column_bytes")
            public static native int columnBytes (IntPtr stmt, int index);

            public static String columnString (IntPtr stmt, int index)
            {
                    return Marshal.ptrToStringUni (SQLite3.columnText16 (stmt, index));
            }

            public static byte[] columnByteArray (IntPtr stmt, int index)
            {
                    int length = columnBytes (stmt, index);
                    byte[] result = new byte[length];
                    if (length > 0) {
                            Marshal.copy (columnBlob (stmt, index), result, 0, length);
                    }
                    return result;
            }

            public enum ColType
            {
                    Integer,
                    Float,
                    Text,
                    Blob,
                    Null
            }
    }
}
