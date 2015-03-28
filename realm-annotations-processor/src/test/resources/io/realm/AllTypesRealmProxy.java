package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import some.test.AllTypes;

public class AllTypesRealmProxy extends AllTypes {

    @Override
    public String getColumnString() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(realm.getColumnIndices().get("AllTypes").get("columnString"));
    }

    @Override
    public void setColumnString(String value) {
        realm.checkIfValid();
        row.setString(realm.getColumnIndices().get("AllTypes").get("columnString"), (String) value);
    }

    @Override
    public long getColumnLong() {
        realm.checkIfValid();
        return (long) row.getLong(realm.getColumnIndices().get("AllTypes").get("columnLong"));
    }

    @Override
    public void setColumnLong(long value) {
        realm.checkIfValid();
        row.setLong(realm.getColumnIndices().get("AllTypes").get("columnLong"), (long) value);
    }

    @Override
    public float getColumnFloat() {
        realm.checkIfValid();
        return (float) row.getFloat(realm.getColumnIndices().get("AllTypes").get("columnFloat"));
    }

    @Override
    public void setColumnFloat(float value) {
        realm.checkIfValid();
        row.setFloat(realm.getColumnIndices().get("AllTypes").get("columnFloat"), (float) value);
    }

    @Override
    public double getColumnDouble() {
        realm.checkIfValid();
        return (double) row.getDouble(realm.getColumnIndices().get("AllTypes").get("columnDouble"));
    }

    @Override
    public void setColumnDouble(double value) {
        realm.checkIfValid();
        row.setDouble(realm.getColumnIndices().get("AllTypes").get("columnDouble"), (double) value);
    }

    @Override
    public boolean isColumnBoolean() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(realm.getColumnIndices().get("AllTypes").get("columnBoolean"));
    }

    @Override
    public void setColumnBoolean(boolean value) {
        realm.checkIfValid();
        row.setBoolean(realm.getColumnIndices().get("AllTypes").get("columnBoolean"), (boolean) value);
    }

    @Override
    public Date getColumnDate() {
        realm.checkIfValid();
        return (java.util.Date) row.getDate(realm.getColumnIndices().get("AllTypes").get("columnDate"));
    }

    @Override
    public void setColumnDate(Date value) {
        realm.checkIfValid();
        row.setDate(realm.getColumnIndices().get("AllTypes").get("columnDate"), (Date) value);
    }

    @Override
    public byte[] getColumnBinary() {
        realm.checkIfValid();
        return (byte[]) row.getBinaryByteArray(realm.getColumnIndices().get("AllTypes").get("columnBinary"));
    }

    @Override
    public void setColumnBinary(byte[] value) {
        realm.checkIfValid();
        row.setBinaryByteArray(realm.getColumnIndices().get("AllTypes").get("columnBinary"), (byte[]) value);
    }

    @Override
    public AllTypes getColumnObject() {
        if (row.isNullLink(realm.getColumnIndices().get("AllTypes").get("columnObject"))) {
            return null;
        }
        return realm.get(some.test.AllTypes.class, row.getLink(realm.getColumnIndices().get("AllTypes").get("columnObject")));
    }

    @Override
    public void setColumnObject(AllTypes value) {
        if (value == null) {
            row.nullifyLink(realm.getColumnIndices().get("AllTypes").get("columnObject"));
            return;
        }
        row.setLink(realm.getColumnIndices().get("AllTypes").get("columnObject"), value.row.getIndex());
    }

    @Override
    public RealmList<AllTypes> getColumnRealmList() {
        return new RealmList<AllTypes>(AllTypes.class, row.getLinkList(realm.getColumnIndices().get("AllTypes").get("columnRealmList")), realm);
    }

    @Override
    public void setColumnRealmList(RealmList<AllTypes> value) {
        LinkView links = row.getLinkList(realm.getColumnIndices().get("AllTypes").get("columnRealmList"));
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_AllTypes")) {
            Table table = transaction.getTable("class_AllTypes");
            table.addColumn(ColumnType.STRING, "columnString");
            table.addColumn(ColumnType.INTEGER, "columnLong");
            table.addColumn(ColumnType.FLOAT, "columnFloat");
            table.addColumn(ColumnType.DOUBLE, "columnDouble");
            table.addColumn(ColumnType.BOOLEAN, "columnBoolean");
            table.addColumn(ColumnType.DATE, "columnDate");
            table.addColumn(ColumnType.BINARY, "columnBinary");
            if (!transaction.hasTable("class_AllTypes")) {
                AllTypesRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "columnObject", transaction.getTable("class_AllTypes"));
            if (!transaction.hasTable("class_AllTypes")) {
                AllTypesRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "columnRealmList", transaction.getTable("class_AllTypes"));
            table.setIndex(table.getColumnIndex("columnString"));
            table.setPrimaryKey("columnString");
            return table;
        }
        return transaction.getTable("class_AllTypes");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_AllTypes")) {
            Table table = transaction.getTable("class_AllTypes");
            if(table.getColumnCount() != 9) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 9; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("columnString")) {
                throw new IllegalStateException("Missing column 'columnString'");
            }
            if (columnTypes.get("columnString") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'columnString'");
            }
            if (!columnTypes.containsKey("columnLong")) {
                throw new IllegalStateException("Missing column 'columnLong'");
            }
            if (columnTypes.get("columnLong") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'long' for column 'columnLong'");
            }
            if (!columnTypes.containsKey("columnFloat")) {
                throw new IllegalStateException("Missing column 'columnFloat'");
            }
            if (columnTypes.get("columnFloat") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'columnFloat'");
            }
            if (!columnTypes.containsKey("columnDouble")) {
                throw new IllegalStateException("Missing column 'columnDouble'");
            }
            if (columnTypes.get("columnDouble") != ColumnType.DOUBLE) {
                throw new IllegalStateException("Invalid type 'double' for column 'columnDouble'");
            }
            if (!columnTypes.containsKey("columnBoolean")) {
                throw new IllegalStateException("Missing column 'columnBoolean'");
            }
            if (columnTypes.get("columnBoolean") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'columnBoolean'");
            }
            if (!columnTypes.containsKey("columnDate")) {
                throw new IllegalStateException("Missing column 'columnDate'");
            }
            if (columnTypes.get("columnDate") != ColumnType.DATE) {
                throw new IllegalStateException("Invalid type 'Date' for column 'columnDate'");
            }
            if (!columnTypes.containsKey("columnBinary")) {
                throw new IllegalStateException("Missing column 'columnBinary'");
            }
            if (columnTypes.get("columnBinary") != ColumnType.BINARY) {
                throw new IllegalStateException("Invalid type 'byte[]' for column 'columnBinary'");
            }
            if (!columnTypes.containsKey("columnObject")) {
                throw new IllegalStateException("Missing column 'columnObject'");
            }
            if (columnTypes.get("columnObject") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'AllTypes' for column 'columnObject'");
            }
            if (!transaction.hasTable("class_AllTypes")) {
                throw new IllegalStateException("Missing table 'class_AllTypes' for column 'columnObject'");
            }
            if(!columnTypes.containsKey("columnRealmList")) {
                throw new IllegalStateException("Missing column 'columnRealmList'");
            }
            if(columnTypes.get("columnRealmList") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'AllTypes' for column 'columnRealmList'");
            }
            if (!transaction.hasTable("class_AllTypes")) {
                throw new IllegalStateException("Missing table 'class_AllTypes' for column 'columnRealmList'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("columnString", "columnLong", "columnFloat", "columnDouble", "columnBoolean", "columnDate", "columnBinary", "columnObject", "columnRealmList");
    }

    public static void populateUsingJsonObject(AllTypes obj, JSONObject json)
            throws JSONException {
        boolean standalone = obj.realm == null;
        if (!json.isNull("columnString")) {
            obj.setColumnString((String) json.getString("columnString"));
        }
        if (!json.isNull("columnLong")) {
            obj.setColumnLong((long) json.getLong("columnLong"));
        }
        if (!json.isNull("columnFloat")) {
            obj.setColumnFloat((float) json.getDouble("columnFloat"));
        }
        if (!json.isNull("columnDouble")) {
            obj.setColumnDouble((double) json.getDouble("columnDouble"));
        }
        if (!json.isNull("columnBoolean")) {
            obj.setColumnBoolean((boolean) json.getBoolean("columnBoolean"));
        }
        if (!json.isNull("columnDate")) {
            Object timestamp = json.get("columnDate");
            if (timestamp instanceof String) {
                obj.setColumnDate(JsonUtils.stringToDate((String) timestamp));
            } else {
                obj.setColumnDate(new Date(json.getLong("columnDate")));
            }
        } else {
            obj.setColumnDate(new Date(0));
        }
        obj.setColumnBinary(JsonUtils.stringToBytes(json.isNull("columnBinary") ? null : json.getString("columnBinary")));
        if (!json.isNull("columnObject")) {
            some.test.AllTypes columnObject = standalone ? new some.test.AllTypes() : obj.realm.createObject(some.test.AllTypes.class);
            AllTypesRealmProxy.populateUsingJsonObject(columnObject, json.getJSONObject("columnObject"));
            obj.setColumnObject(columnObject);
        }
        if (!json.isNull("columnRealmList")) {
            if (standalone) {
                obj.setColumnRealmList(new RealmList<some.test.AllTypes>());
            }
            JSONArray array = json.getJSONArray("columnRealmList");
            for (int i = 0; i < array.length(); i++) {
                some.test.AllTypes item = standalone ? new some.test.AllTypes() : obj.realm.createObject(some.test.AllTypes.class);
                AllTypesRealmProxy.populateUsingJsonObject(item, array.getJSONObject(i));
                obj.getColumnRealmList().add(item);
            }
        }
    }

    public static void populateUsingJsonStream(AllTypes obj, JsonReader reader)
            throws IOException {
        boolean standalone = obj.realm == null;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("columnString") && reader.peek() != JsonToken.NULL) {
                obj.setColumnString((String) reader.nextString());
            } else if (name.equals("columnLong")  && reader.peek() != JsonToken.NULL) {
                obj.setColumnLong((long) reader.nextLong());
            } else if (name.equals("columnFloat")  && reader.peek() != JsonToken.NULL) {
                obj.setColumnFloat((float) reader.nextDouble());
            } else if (name.equals("columnDouble")  && reader.peek() != JsonToken.NULL) {
                obj.setColumnDouble((double) reader.nextDouble());
            } else if (name.equals("columnBoolean")  && reader.peek() != JsonToken.NULL) {
                obj.setColumnBoolean((boolean) reader.nextBoolean());
            } else if (name.equals("columnDate")  && reader.peek() != JsonToken.NULL) {
                if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        obj.setColumnDate(new Date(timestamp));
                    }
                } else {
                    obj.setColumnDate(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("columnBinary")  && reader.peek() != JsonToken.NULL) {
                obj.setColumnBinary(JsonUtils.stringToBytes(reader.nextString()));
            } else if (name.equals("columnObject")  && reader.peek() != JsonToken.NULL) {
                some.test.AllTypes columnObjectObj = standalone ? new some.test.AllTypes() : obj.realm.createObject(some.test.AllTypes.class);
                AllTypesRealmProxy.populateUsingJsonStream(columnObjectObj, reader);
                obj.setColumnObject(columnObjectObj);
            } else if (name.equals("columnRealmList")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                if (standalone) {
                    obj.setColumnRealmList(new RealmList<some.test.AllTypes>());
                }
                while (reader.hasNext()) {
                    some.test.AllTypes item = standalone ? new some.test.AllTypes() : obj.realm.createObject(some.test.AllTypes.class);
                    AllTypesRealmProxy.populateUsingJsonStream(item, reader);
                    obj.getColumnRealmList().add(item);
                }
                reader.endArray();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    public static AllTypes copyOrUpdate(Realm realm, AllTypes object, boolean update, Map<RealmObject,RealmObject> cache) {
        AllTypes realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(AllTypes.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getColumnString());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new AllTypesRealmProxy();
                realmObject.realm = realm;
                realmObject.row = table.getRow(rowIndex);
                cache.put(object, realmObject);
            } else {
                canUpdate = false;
            }
        }

        if (canUpdate) {
            return update(realm, realmObject, object, cache);
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static AllTypes copy(Realm realm, AllTypes newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        AllTypes realmObject = realm.createObject(AllTypes.class);
        cache.put(newObject, realmObject);
        realmObject.setColumnString(newObject.getColumnString() != null ? newObject.getColumnString() : "");
        realmObject.setColumnLong(newObject.getColumnLong());
        realmObject.setColumnFloat(newObject.getColumnFloat());
        realmObject.setColumnDouble(newObject.getColumnDouble());
        realmObject.setColumnBoolean(newObject.isColumnBoolean());
        realmObject.setColumnDate(newObject.getColumnDate() != null ? newObject.getColumnDate() : new Date(0));
        realmObject.setColumnBinary(newObject.getColumnBinary() != null ? newObject.getColumnBinary() : new byte[0]);

        some.test.AllTypes columnObjectObj = newObject.getColumnObject();
        if (columnObjectObj != null) {
            some.test.AllTypes cachecolumnObject = (some.test.AllTypes) cache.get(columnObjectObj);
            if (cachecolumnObject != null) {
                realmObject.setColumnObject(cachecolumnObject);
            } else {
                realmObject.setColumnObject(AllTypesRealmProxy.copyOrUpdate(realm, columnObjectObj, update, cache));
            }
        }

        RealmList<AllTypes> columnRealmListList = newObject.getColumnRealmList();
        if (columnRealmListList != null) {
            RealmList<AllTypes> columnRealmListRealmList = realmObject.getColumnRealmList();
            for (int i = 0; i < columnRealmListList.size(); i++) {
                AllTypes columnRealmListItem = columnRealmListList.get(i);
                AllTypes cachecolumnRealmList = (AllTypes) cache.get(columnRealmListItem);
                if (cachecolumnRealmList != null) {
                    columnRealmListRealmList.add(cachecolumnRealmList);
                } else {
                    columnRealmListRealmList.add(AllTypesRealmProxy.copyOrUpdate(realm, columnRealmListList.get(i), update, cache));
                }
            }
        }

        return realmObject;
    }

    static AllTypes update(Realm realm, AllTypes realmObject, AllTypes newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setColumnLong(newObject.getColumnLong());
        realmObject.setColumnFloat(newObject.getColumnFloat());
        realmObject.setColumnDouble(newObject.getColumnDouble());
        realmObject.setColumnBoolean(newObject.isColumnBoolean());
        realmObject.setColumnDate(newObject.getColumnDate() != null ? newObject.getColumnDate() : new Date(0));
        realmObject.setColumnBinary(newObject.getColumnBinary() != null ? newObject.getColumnBinary() : new byte[0]);
        AllTypes columnObjectObj = newObject.getColumnObject();
        if (columnObjectObj != null) {
            AllTypes cachecolumnObject = (AllTypes) cache.get(columnObjectObj);
            if (cachecolumnObject != null) {
                realmObject.setColumnObject(cachecolumnObject);
            } else {
                realmObject.setColumnObject(AllTypesRealmProxy.copyOrUpdate(realm, columnObjectObj, true, cache));
            }
        } else {
            realmObject.setColumnObject(null);
        }
        RealmList<AllTypes> columnRealmListList = newObject.getColumnRealmList();
        RealmList<AllTypes> columnRealmListRealmList = realmObject.getColumnRealmList();
        columnRealmListRealmList.clear();
        if (columnRealmListList != null) {
            for (int i = 0; i < columnRealmListList.size(); i++) {
                AllTypes columnRealmListItem = columnRealmListList.get(i);
                AllTypes cachecolumnRealmList = (AllTypes) cache.get(columnRealmListItem);
                if (cachecolumnRealmList != null) {
                    columnRealmListRealmList.add(cachecolumnRealmList);
                } else {
                    columnRealmListRealmList.add(AllTypesRealmProxy.copyOrUpdate(realm, columnRealmListList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("AllTypes = [");
        stringBuilder.append("{columnString:");
        stringBuilder.append(getColumnString());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{columnLong:");
        stringBuilder.append(getColumnLong());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{columnFloat:");
        stringBuilder.append(getColumnFloat());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{columnDouble:");
        stringBuilder.append(getColumnDouble());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{columnBoolean:");
        stringBuilder.append(isColumnBoolean());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{columnDate:");
        stringBuilder.append(getColumnDate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{columnBinary:");
        stringBuilder.append(getColumnBinary());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{columnObject:");
        stringBuilder.append(getColumnObject() != null ? "AllTypes" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{columnRealmList:");
        stringBuilder.append("RealmList<AllTypes>[").append(getColumnRealmList().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTypesRealmProxy aAllTypes = (AllTypesRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aAllTypes.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aAllTypes.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aAllTypes.row.getIndex()) return false;

        return true;
    }

}