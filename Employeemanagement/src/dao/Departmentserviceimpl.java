package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.*;

import exception.DepartmentNotFoundException;
import model.Department;

import java.sql.*;

import util.DBconn;



public class Departmentserviceimpl implements Departmentservice {



	public List<Department> getAllDepartmentss(){ // get all the details

	List<Department> list = new ArrayList<>();//object created

	String query = "select * from Department";

	try(Connection con=DBconn.getConnection();

		PreparedStatement ps=con.prepareStatement(query))

	{

		ResultSet rs=ps.executeQuery();

		while(rs.next())

		{

			//list.add(new Department(rs.getInt("deptid"),rs.getString("deptname")));

		int departmentID = rs.getInt("deptid");

        String departmentName = rs.getString("deptname");

        System.out.println("ID: " + departmentID + ", Name: " + departmentName);

		}

	}

	catch(Exception e)

	{

		System.out.println(e);

	}

	return list;



}



	public Department getDept(int deptid) {

		String sql = "SELECT * FROM Department WHERE deptid = ?";

		Department dept = null;

        try(Connection conn =DBconn.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, deptid);

            ResultSet rs = stmt.executeQuery();

            int departmentID=0;

            if(rs!=null)

            {

            while(rs.next())

			{

				//list.add(new Department(rs.getInt("deptid"),rs.getString("deptname")));

            departmentID = rs.getInt("deptid");

            String departmentName = rs.getString("deptname");

            System.out.println("ID: " + departmentID + ", Name: " + departmentName);

			}

            }

            if(departmentID != deptid)

            throw new DepartmentNotFoundException("Department with deptid: " + deptid + " not found");

            return dept;

        } catch (SQLException e) {

            System.out.println("Error Occurred 2: " + e.getMessage());

        } catch (DepartmentNotFoundException e) {

            System.out.println("Error Occurred : " + e.getMessage());

 

        }

        return null;

	}

}