package sample.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sample.common.AesCipher;
import sample.common.ApplicationContextProvider;

public class AesCipherTypeHandler implements TypeHandler<String> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AesCipherTypeHandler.class);

	@Override
	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		String password = null;
		if (parameter != null) {
			try {
				AesCipher aesCipher = (AesCipher) ApplicationContextProvider.getBean("aesCipher");
				password = aesCipher.encrypt(parameter);
			} catch (Exception e) { 
				LOGGER.debug(e.getMessage());
			}
		}
		ps.setString(i, password);
	}

	@Override
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		String retValue = null;
		try {
			AesCipher aesCipher = (AesCipher) ApplicationContextProvider.getBean("aesCipher");
			retValue = aesCipher.decrypt(rs.getString(columnName));
		} catch (Exception e) {
			retValue = rs.getString(columnName);
		}
		return retValue;
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		String retValue = null;
		try {
			AesCipher aesCipher = (AesCipher) ApplicationContextProvider.getBean("aesCipher");
			retValue = aesCipher.decrypt(rs.getString(columnIndex));
		} catch (Exception e) {
			retValue = rs.getString(columnIndex);
		}
		return retValue;
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String retValue = null;
		try {
			AesCipher aesCipher = (AesCipher) ApplicationContextProvider.getBean("aesCipher");
			retValue = aesCipher.decrypt(cs.getString(columnIndex));
		} catch (Exception e) {
			retValue = cs.getString(columnIndex);
		}
		return retValue;
	}

}
