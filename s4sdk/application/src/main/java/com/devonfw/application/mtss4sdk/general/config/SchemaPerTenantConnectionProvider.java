package com.devonfw.application.mtss4sdk.general.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;

//s. comment in TenantIdentifierResolver
//@Component
//@Profile("cloud")
public class SchemaPerTenantConnectionProvider implements MultiTenantConnectionProvider {

	private static final long serialVersionUID = 2634126769726865523L;

	@Autowired
	private DataSource dataSource;

	@Override
	public Connection getAnyConnection() throws SQLException {
		return this.dataSource.getConnection();
	}

	@Override
	public void releaseAnyConnection(final Connection connection) throws SQLException {
		connection.close();
	}

	@Override
	public Connection getConnection(final String tenantIdentifier) throws SQLException {
		final Connection connection = this.getAnyConnection();
		try {
			connection.setSchema(TenantUtil.createSchemaName(tenantIdentifier));
		} catch (SQLException e) {
			throw new HibernateException(
					"Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]", e);
		}
		return connection;
	}

	@Override
	public void releaseConnection(final String tenantIdentifier, final Connection connection) throws SQLException {
		try {
			connection.setSchema(TenantUtil.createSchemaName(tenantIdentifier));
		} catch (SQLException e) {
			throw new HibernateException(
					"Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]", e);
		}

		connection.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		return true;
	}

	@Override
	public boolean isUnwrappableAs(final Class aClass) {
		return false;
	}

	@Override
	public <T> T unwrap(final Class<T> aClass) {
		return null;
	}

}
