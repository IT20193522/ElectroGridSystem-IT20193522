package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class UsersAPI
 */
@WebServlet("/UsersAPI")
public class UsersAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User comObj = new User();
    /**
     * Default constructor. 
     */
    public UsersAPI() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		User comObj = new User();
		
		String output = "";
		output = comObj.readUser();
		
		response.getWriter().append(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String output = comObj.insertUser(
				request.getParameter("name"), 
				request.getParameter("date"),
				request.getParameter("nic"), 
				request.getParameter("password"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = "";
		if (paras.get("iduser") != null) {
			output = comObj.updateUser(
					paras.get("iduser").toString(),
					paras.get("name").toString(),
					paras.get("date").toString(), 
					paras.get("nic").toString(), 
					paras.get("password").toString());
		}
		else {
			output = comObj.updateUser(
					request.getParameter("iduser"), 
					request.getParameter("name"), 
					request.getParameter("date"), 
					request.getParameter("nic"), 
					request.getParameter("password"));
		}
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = "";
		if (paras.get("iduser"
				+ "") != null) {
			output = comObj.deleteUser(paras.get("iduser").toString());
		}
		else {
			output = comObj.deleteUser(request.getParameter("iduser"));
		}
		System.out.println("ID: " + output);
		response.getWriter().write(output);
	}

	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {

				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}
}
