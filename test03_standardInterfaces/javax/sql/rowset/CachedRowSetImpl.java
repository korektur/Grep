package javax.sql.rowset;
public class CachedRowSetImpl implements javax.sql.rowset.CachedRowSet {

    @Override
    public int size(){
        return 1;
    }

    @Override
    public void release() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void execute(java.sql.Connection arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void acceptChanges(java.sql.Connection arg0) throws javax.sql.rowset.spi.SyncProviderException{
        return ;
    }

    @Override
    public void acceptChanges() throws javax.sql.rowset.spi.SyncProviderException{
        return ;
    }

    @Override
    public boolean columnUpdated(int arg0) throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean columnUpdated(java.lang.String arg0) throws java.sql.SQLException{
        return true;
    }

    @Override
    public void commit() throws java.sql.SQLException{
        return ;
    }

    @Override
    public javax.sql.rowset.CachedRowSet createCopy() throws java.sql.SQLException{
        return null;
    }

    @Override
    public javax.sql.rowset.CachedRowSet createCopyNoConstraints() throws java.sql.SQLException{
        return null;
    }

    @Override
    public javax.sql.rowset.CachedRowSet createCopySchema() throws java.sql.SQLException{
        return null;
    }

    @Override
    public javax.sql.RowSet createShared() throws java.sql.SQLException{
        return null;
    }

    @Override
    public int[] getKeyColumns() throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.ResultSet getOriginal() throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.ResultSet getOriginalRow() throws java.sql.SQLException{
        return null;
    }

    @Override
    public int getPageSize(){
        return 1;
    }

    @Override
    public javax.sql.rowset.RowSetWarning getRowSetWarnings() throws java.sql.SQLException{
        return null;
    }

    @Override
    public boolean getShowDeleted() throws java.sql.SQLException{
        return true;
    }

    @Override
    public javax.sql.rowset.spi.SyncProvider getSyncProvider() throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.String getTableName() throws java.sql.SQLException{
        return null;
    }

    @Override
    public boolean nextPage() throws java.sql.SQLException{
        return true;
    }

    @Override
    public void populate(java.sql.ResultSet arg0, int arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void populate(java.sql.ResultSet arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public boolean previousPage() throws java.sql.SQLException{
        return true;
    }

    @Override
    public void restoreOriginal() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void rollback(java.sql.Savepoint arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void rollback() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void rowSetPopulated(javax.sql.RowSetEvent arg0, int arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setKeyColumns(int[] arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setMetaData(javax.sql.RowSetMetaData arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setOriginalRow() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setPageSize(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setShowDeleted(boolean arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setSyncProvider(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTableName(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public java.util.Collection toCollection(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.util.Collection toCollection(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.util.Collection toCollection() throws java.sql.SQLException{
        return null;
    }

    @Override
    public void undoDelete() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void undoInsert() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void undoUpdate() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setReadOnly(boolean arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBoolean(int arg0, boolean arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBoolean(java.lang.String arg0, boolean arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setByte(int arg0, byte arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setByte(java.lang.String arg0, byte arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setDouble(int arg0, double arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setDouble(java.lang.String arg0, double arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setFloat(java.lang.String arg0, float arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setFloat(int arg0, float arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setInt(int arg0, int arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setInt(java.lang.String arg0, int arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setLong(java.lang.String arg0, long arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setLong(int arg0, long arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setShort(java.lang.String arg0, short arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setShort(int arg0, short arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public boolean isReadOnly(){
        return true;
    }

    @Override
    public void setTimestamp(java.lang.String arg0, java.sql.Timestamp arg1, java.util.Calendar arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTimestamp(int arg0, java.sql.Timestamp arg1, java.util.Calendar arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTimestamp(int arg0, java.sql.Timestamp arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTimestamp(java.lang.String arg0, java.sql.Timestamp arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setURL(int arg0, java.net.URL arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTime(int arg0, java.sql.Time arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTime(java.lang.String arg0, java.sql.Time arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTime(java.lang.String arg0, java.sql.Time arg1, java.util.Calendar arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTime(int arg0, java.sql.Time arg1, java.util.Calendar arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void execute() throws java.sql.SQLException{
        return ;
    }

    @Override
    public java.lang.String getPassword(){
        return null;
    }

    @Override
    public void setObject(int arg0, java.lang.Object arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setObject(int arg0, java.lang.Object arg1, int arg2, int arg3) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setObject(java.lang.String arg0, java.lang.Object arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setObject(java.lang.String arg0, java.lang.Object arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setObject(int arg0, java.lang.Object arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setObject(java.lang.String arg0, java.lang.Object arg1, int arg2, int arg3) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setType(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setDate(java.lang.String arg0, java.sql.Date arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setDate(java.lang.String arg0, java.sql.Date arg1, java.util.Calendar arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setDate(int arg0, java.sql.Date arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setDate(int arg0, java.sql.Date arg1, java.util.Calendar arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void addRowSetListener(javax.sql.RowSetListener arg0){
        return ;
    }

    @Override
    public void clearParameters() throws java.sql.SQLException{
        return ;
    }

    @Override
    public java.lang.String getCommand(){
        return null;
    }

    @Override
    public java.lang.String getDataSourceName(){
        return null;
    }

    @Override
    public boolean getEscapeProcessing() throws java.sql.SQLException{
        return true;
    }

    @Override
    public int getMaxFieldSize() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public int getMaxRows() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public int getQueryTimeout() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public int getTransactionIsolation(){
        return 1;
    }

    @Override
    public java.util.Map getTypeMap() throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.String getUrl() throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.String getUsername(){
        return null;
    }

    @Override
    public void removeRowSetListener(javax.sql.RowSetListener arg0){
        return ;
    }

    @Override
    public void setArray(int arg0, java.sql.Array arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setAsciiStream(int arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setAsciiStream(java.lang.String arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setAsciiStream(java.lang.String arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setAsciiStream(int arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBigDecimal(int arg0, java.math.BigDecimal arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBigDecimal(java.lang.String arg0, java.math.BigDecimal arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBinaryStream(java.lang.String arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBinaryStream(int arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBinaryStream(java.lang.String arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBinaryStream(int arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBlob(java.lang.String arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBlob(int arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBlob(int arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBlob(int arg0, java.sql.Blob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBlob(java.lang.String arg0, java.sql.Blob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBlob(java.lang.String arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBytes(java.lang.String arg0, byte[] arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setBytes(int arg0, byte[] arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setCharacterStream(int arg0, java.io.Reader arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setCharacterStream(java.lang.String arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setCharacterStream(int arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setCharacterStream(java.lang.String arg0, java.io.Reader arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setClob(int arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setClob(java.lang.String arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setClob(java.lang.String arg0, java.sql.Clob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setClob(int arg0, java.sql.Clob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setClob(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setClob(java.lang.String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setCommand(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setConcurrency(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setDataSourceName(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setEscapeProcessing(boolean arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setMaxFieldSize(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setMaxRows(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNCharacterStream(int arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNCharacterStream(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNCharacterStream(java.lang.String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNCharacterStream(java.lang.String arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNClob(java.lang.String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNClob(int arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNClob(java.lang.String arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNClob(java.lang.String arg0, java.sql.NClob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNClob(int arg0, java.sql.NClob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNClob(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNString(java.lang.String arg0, java.lang.String arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNString(int arg0, java.lang.String arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNull(int arg0, int arg1, java.lang.String arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNull(java.lang.String arg0, int arg1, java.lang.String arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNull(int arg0, int arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setNull(java.lang.String arg0, int arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setPassword(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setQueryTimeout(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setRef(int arg0, java.sql.Ref arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setRowId(int arg0, java.sql.RowId arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setRowId(java.lang.String arg0, java.sql.RowId arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setSQLXML(java.lang.String arg0, java.sql.SQLXML arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setSQLXML(int arg0, java.sql.SQLXML arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setString(int arg0, java.lang.String arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setString(java.lang.String arg0, java.lang.String arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTransactionIsolation(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setTypeMap(java.util.Map arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setUrl(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setUsername(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public java.lang.Object getObject(java.lang.String arg0, java.util.Map arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.Object getObject(int arg0, java.util.Map arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.Object getObject(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.Object getObject(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.Object getObject(int arg0, java.lang.Class arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.Object getObject(java.lang.String arg0, java.lang.Class arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public boolean getBoolean(java.lang.String arg0) throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean getBoolean(int arg0) throws java.sql.SQLException{
        return true;
    }

    @Override
    public byte getByte(java.lang.String arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public byte getByte(int arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public short getShort(int arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public short getShort(java.lang.String arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public int getInt(java.lang.String arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public int getInt(int arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public long getLong(java.lang.String arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public long getLong(int arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public float getFloat(int arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public float getFloat(java.lang.String arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public double getDouble(java.lang.String arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public double getDouble(int arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public byte[] getBytes(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public byte[] getBytes(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Array getArray(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Array getArray(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public boolean next() throws java.sql.SQLException{
        return true;
    }

    @Override
    public java.net.URL getURL(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.net.URL getURL(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public void close() throws java.sql.SQLException{
        return ;
    }

    @Override
    public int getType() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public boolean previous() throws java.sql.SQLException{
        return true;
    }

    @Override
    public java.lang.String getString(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.String getString(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Ref getRef(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Ref getRef(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Date getDate(int arg0, java.util.Calendar arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Date getDate(java.lang.String arg0, java.util.Calendar arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Date getDate(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Date getDate(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Time getTime(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Time getTime(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Time getTime(int arg0, java.util.Calendar arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Time getTime(java.lang.String arg0, java.util.Calendar arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public boolean isClosed() throws java.sql.SQLException{
        return true;
    }

    @Override
    public java.sql.Timestamp getTimestamp(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Timestamp getTimestamp(int arg0, java.util.Calendar arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Timestamp getTimestamp(java.lang.String arg0, java.util.Calendar arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Timestamp getTimestamp(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public void updateBytes(java.lang.String arg0, byte[] arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBytes(int arg0, byte[] arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public boolean last() throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean first() throws java.sql.SQLException{
        return true;
    }

    @Override
    public java.sql.Statement getStatement() throws java.sql.SQLException{
        return null;
    }

    @Override
    public boolean isFirst() throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean absolute(int arg0) throws java.sql.SQLException{
        return true;
    }

    @Override
    public void afterLast() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void beforeFirst() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void cancelRowUpdates() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void clearWarnings() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void deleteRow() throws java.sql.SQLException{
        return ;
    }

    @Override
    public int findColumn(java.lang.String arg0) throws java.sql.SQLException{
        return 1;
    }

    @Override
    public java.io.InputStream getAsciiStream(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.InputStream getAsciiStream(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.math.BigDecimal getBigDecimal(int arg0, int arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.math.BigDecimal getBigDecimal(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.math.BigDecimal getBigDecimal(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.math.BigDecimal getBigDecimal(java.lang.String arg0, int arg1) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.InputStream getBinaryStream(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.InputStream getBinaryStream(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Blob getBlob(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Blob getBlob(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.Reader getCharacterStream(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.Reader getCharacterStream(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Clob getClob(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.Clob getClob(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public int getConcurrency() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public java.lang.String getCursorName() throws java.sql.SQLException{
        return null;
    }

    @Override
    public int getFetchDirection() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public int getFetchSize() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public int getHoldability() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public java.sql.ResultSetMetaData getMetaData() throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.Reader getNCharacterStream(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.Reader getNCharacterStream(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.NClob getNClob(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.NClob getNClob(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.String getNString(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.String getNString(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public int getRow() throws java.sql.SQLException{
        return 1;
    }

    @Override
    public java.sql.RowId getRowId(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.RowId getRowId(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.SQLXML getSQLXML(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.SQLXML getSQLXML(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.InputStream getUnicodeStream(java.lang.String arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.io.InputStream getUnicodeStream(int arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.sql.SQLWarning getWarnings() throws java.sql.SQLException{
        return null;
    }

    @Override
    public void insertRow() throws java.sql.SQLException{
        return ;
    }

    @Override
    public boolean isAfterLast() throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean isBeforeFirst() throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean isLast() throws java.sql.SQLException{
        return true;
    }

    @Override
    public void moveToCurrentRow() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void moveToInsertRow() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void refreshRow() throws java.sql.SQLException{
        return ;
    }

    @Override
    public boolean relative(int arg0) throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean rowDeleted() throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean rowInserted() throws java.sql.SQLException{
        return true;
    }

    @Override
    public boolean rowUpdated() throws java.sql.SQLException{
        return true;
    }

    @Override
    public void setFetchDirection(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setFetchSize(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateArray(int arg0, java.sql.Array arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateArray(java.lang.String arg0, java.sql.Array arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateAsciiStream(int arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateAsciiStream(java.lang.String arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateAsciiStream(int arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateAsciiStream(java.lang.String arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateAsciiStream(java.lang.String arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateAsciiStream(int arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBigDecimal(int arg0, java.math.BigDecimal arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBigDecimal(java.lang.String arg0, java.math.BigDecimal arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBinaryStream(java.lang.String arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBinaryStream(int arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBinaryStream(java.lang.String arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBinaryStream(int arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBinaryStream(int arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBinaryStream(java.lang.String arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBlob(int arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBlob(int arg0, java.sql.Blob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBlob(java.lang.String arg0, java.io.InputStream arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBlob(java.lang.String arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBlob(java.lang.String arg0, java.sql.Blob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBlob(int arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBoolean(java.lang.String arg0, boolean arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateBoolean(int arg0, boolean arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateByte(java.lang.String arg0, byte arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateByte(int arg0, byte arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateCharacterStream(int arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateCharacterStream(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateCharacterStream(java.lang.String arg0, java.io.Reader arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateCharacterStream(java.lang.String arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateCharacterStream(int arg0, java.io.Reader arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateCharacterStream(java.lang.String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateClob(int arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateClob(int arg0, java.sql.Clob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateClob(java.lang.String arg0, java.sql.Clob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateClob(java.lang.String arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateClob(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateClob(java.lang.String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateDate(java.lang.String arg0, java.sql.Date arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateDate(int arg0, java.sql.Date arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateDouble(java.lang.String arg0, double arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateDouble(int arg0, double arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateFloat(java.lang.String arg0, float arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateFloat(int arg0, float arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateInt(int arg0, int arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateInt(java.lang.String arg0, int arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateLong(java.lang.String arg0, long arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateLong(int arg0, long arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNCharacterStream(java.lang.String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNCharacterStream(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNCharacterStream(int arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNCharacterStream(java.lang.String arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNClob(java.lang.String arg0, java.sql.NClob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNClob(java.lang.String arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNClob(int arg0, java.io.Reader arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNClob(java.lang.String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNClob(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNClob(int arg0, java.sql.NClob arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNString(java.lang.String arg0, java.lang.String arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNString(int arg0, java.lang.String arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNull(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateNull(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateObject(java.lang.String arg0, java.lang.Object arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateObject(int arg0, java.lang.Object arg1, int arg2) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateObject(int arg0, java.lang.Object arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateObject(java.lang.String arg0, java.lang.Object arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateRef(java.lang.String arg0, java.sql.Ref arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateRef(int arg0, java.sql.Ref arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateRow() throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateRowId(java.lang.String arg0, java.sql.RowId arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateRowId(int arg0, java.sql.RowId arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateSQLXML(int arg0, java.sql.SQLXML arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateSQLXML(java.lang.String arg0, java.sql.SQLXML arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateShort(java.lang.String arg0, short arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateShort(int arg0, short arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateString(int arg0, java.lang.String arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateString(java.lang.String arg0, java.lang.String arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateTime(int arg0, java.sql.Time arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateTime(java.lang.String arg0, java.sql.Time arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateTimestamp(int arg0, java.sql.Timestamp arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void updateTimestamp(java.lang.String arg0, java.sql.Timestamp arg1) throws java.sql.SQLException{
        return ;
    }

    @Override
    public boolean wasNull() throws java.sql.SQLException{
        return true;
    }

    @Override
    public java.lang.Object unwrap(java.lang.Class arg0) throws java.sql.SQLException{
        return null;
    }

    @Override
    public boolean isWrapperFor(java.lang.Class arg0) throws java.sql.SQLException{
        return true;
    }

    @Override
    public int[] getMatchColumnIndexes() throws java.sql.SQLException{
        return null;
    }

    @Override
    public java.lang.String[] getMatchColumnNames() throws java.sql.SQLException{
        return null;
    }

    @Override
    public void setMatchColumn(int arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setMatchColumn(java.lang.String[] arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setMatchColumn(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void setMatchColumn(int[] arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void unsetMatchColumn(java.lang.String arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void unsetMatchColumn(java.lang.String[] arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void unsetMatchColumn(int[] arg0) throws java.sql.SQLException{
        return ;
    }

    @Override
    public void unsetMatchColumn(int arg0) throws java.sql.SQLException{
        return ;
    }
}