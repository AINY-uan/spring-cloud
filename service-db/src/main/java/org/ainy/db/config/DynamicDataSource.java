package org.ainy.db.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {

        return DataSourceContextHolder.getDatabaseType();
    }
}
