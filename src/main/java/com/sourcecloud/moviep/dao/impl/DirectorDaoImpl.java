package com.sourcecloud.moviep.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.sourcecloud.moviep.dao.DirectorDao;
import com.sourcecloud.moviep.model.Director;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;


@Component
public  class DirectorDaoImpl implements DirectorDao {

		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		
		
		public List<Director> getDirectors() {
			
			List<Director> directors = new ArrayList<Director>();
			
			
			List<Map<String, Object>> rows =  jdbcTemplate.queryForList("SELECT * FROM DIRECTOR");
			
			for (Map<String, Object> row : rows) {
				
				Director dr = new Director();
				dr.setId((Integer)(row.get("ID")));
				dr.setName((String)row.get("NAME"));
				dr.setReleaseDate((String)row.get("ReleaseDate"));
				dr.setLeadActor((String)row.get("LeadActor"));
				dr.setLeadActress((String)row.get("LeadActress"));
				dr.setDirector((String)row.get("Director"));
				dr.setProdectionHouse((String)row.get("ProdectionHouse"));
				directors.add(dr);
			}
			
					
			
			
			return directors;
		}

		
		public void createDirector(final Director director) {
			
			String sql = "INSERT INTO DIRECTOR VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>(){

				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setInt(1,director.getId());  
			        ps.setString(2,director.getName());  
			        ps.setString(3,director.getReleaseDate()); 
			        ps.setString(4,director.getLeadActor());
			        ps.setString(5,director.getLeadActress());
			        ps.setString(6,director.getDirector());
			        ps.setString(7,director.getProdectionHouse());
			        return ps.execute();  
				}
			    	    
				

				  
			    });  
			
			

		}
		
		
		public void updateDirector(Director director) {
			// TODO Auto-generated method stub

		}

		
		

}
	
	

