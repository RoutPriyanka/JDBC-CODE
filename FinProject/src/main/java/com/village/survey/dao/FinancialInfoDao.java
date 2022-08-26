package com.village.survey.dao;
//package com.village.survey.dao;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//
//import com.village.survey.entity.FinancialInfo;
//import com.village.survey.rowmapper.FinancialInfoRowMapper;
//
//public class FinancialInfoDao {
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired(required = false)
//	private HashMap<String, String> queries;
//
//	private SimpleJdbcInsert simpleJdbcInsert;
//
//	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//	@Autowired
//	private DataSource dataSource;
//
//	@PostConstruct
//	private void postConstruct() {
//		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("financial_info").withSchemaName("public")
//				.usingGeneratedKeyColumns("id");
//	}
//
//	/**
//	 * @param financialInfo
//	 * @return
//	 */
//	public FinancialInfo save(FinancialInfo financialInfo) {
//		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(financialInfo);
//		financialInfo.setId((Long) simpleJdbcInsert.executeAndReturnKey(namedParameters));
//		logger.info("record inserted to FinancialInfo table");
//		return financialInfo;
//	}
//
//	/**
//	 * 
//	 * @param id
//	 * @return
//	 */
//	public List<FinancialInfo> findById(Long id) {
//		Map<String, Object> parameters = new HashMap<>();
//		parameters.put("id", id);
//		return namedParameterJdbcTemplate.query(queries.get("financialInfo_find_by_id"), parameters,
//				new FinancialInfoRowMapper());
//	}
//
//	/**
//	 * @param financialInfo
//	 * @return
//	 */
//	public FinancialInfo updte(FinancialInfo financialInfo) {
//		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(financialInfo);
//		namedParameterJdbcTemplate.update(queries.get("financialInfo_update"), namedParameters);
//		logger.info("updated to FinancialInfo table");
//		return financialInfo;
//	}
//
//	/**
//	 * @return
//	 */
//	public List<FinancialInfo> findAll() {
//		return namedParameterJdbcTemplate
//				.query(queries.get("financialInfo_find_all"), new FinancialInfoRowMapper());
//	}
//
//}
