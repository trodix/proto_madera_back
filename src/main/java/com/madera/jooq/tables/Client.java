/*
 * This file is generated by jOOQ.
 */
package com.madera.jooq.tables;


import com.madera.jooq.Indexes;
import com.madera.jooq.Keys;
import com.madera.jooq.Madera;
import com.madera.jooq.tables.records.ClientRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Client extends TableImpl<ClientRecord> {

    private static final long serialVersionUID = 72538633;

    /**
     * The reference instance of <code>madera.client</code>
     */
    public static final Client CLIENT = new Client();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClientRecord> getRecordType() {
        return ClientRecord.class;
    }

    /**
     * The column <code>madera.client.i_client_id</code>.
     */
    public final TableField<ClientRecord, Integer> I_CLIENT_ID = createField(DSL.name("i_client_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>madera.client.v_nom</code>.
     */
    public final TableField<ClientRecord, String> V_NOM = createField(DSL.name("v_nom"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>madera.client.v_prenom</code>.
     */
    public final TableField<ClientRecord, String> V_PRENOM = createField(DSL.name("v_prenom"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>madera.client.v_tel</code>.
     */
    public final TableField<ClientRecord, String> V_TEL = createField(DSL.name("v_tel"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>madera.client.v_mail</code>.
     */
    public final TableField<ClientRecord, String> V_MAIL = createField(DSL.name("v_mail"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * Create a <code>madera.client</code> table reference
     */
    public Client() {
        this(DSL.name("client"), null);
    }

    /**
     * Create an aliased <code>madera.client</code> table reference
     */
    public Client(String alias) {
        this(DSL.name(alias), CLIENT);
    }

    /**
     * Create an aliased <code>madera.client</code> table reference
     */
    public Client(Name alias) {
        this(alias, CLIENT);
    }

    private Client(Name alias, Table<ClientRecord> aliased) {
        this(alias, aliased, null);
    }

    private Client(Name alias, Table<ClientRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Client(Table<O> child, ForeignKey<O, ClientRecord> key) {
        super(child, key, CLIENT);
    }

    @Override
    public Schema getSchema() {
        return Madera.MADERA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CLIENT_PKEY);
    }

    @Override
    public UniqueKey<ClientRecord> getPrimaryKey() {
        return Keys.CLIENT_PKEY;
    }

    @Override
    public List<UniqueKey<ClientRecord>> getKeys() {
        return Arrays.<UniqueKey<ClientRecord>>asList(Keys.CLIENT_PKEY);
    }

    @Override
    public Client as(String alias) {
        return new Client(DSL.name(alias), this);
    }

    @Override
    public Client as(Name alias) {
        return new Client(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Client rename(String name) {
        return new Client(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Client rename(Name name) {
        return new Client(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
