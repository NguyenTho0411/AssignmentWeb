/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import email.bussiness.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/index.html";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String birthDate = request.getParameter("birthDate");
            User user = new User(firstName, lastName, email, birthDate);
            request.setAttribute("user", user);
            String hear = request.getParameter("hear");
            request.setAttribute("hear", hear);
            String receive = "";
            String[] selectedValues = request.getParameterValues("receive"); // Đúng tên "receive"
            if (selectedValues != null) { // Kiểm tra xem có giá trị nào được chọn không
                for (String value : selectedValues) {
                    if ("no".equals(value)) { // Kiểm tra giá trị của value thay vì receive
                        receive += "Yes, I'd like that ";
                    } else if ("like".equals(value)) {
                        receive += "Yes, please send me the email announcement";
                    }
                }
            }
            request.setAttribute("receive", receive);

            String contactMethod = request.getParameter("contact");

            // Kiểm tra giá trị đã nhận được và xử lý tương ứng
            String message;
            if (contactMethod != null) {
                switch (contactMethod) {
                    case "email_postal":
                        message = "Email or postal";
                        break;
                    case "email":
                        message = "Email only";
                        break;
                    case "postal":
                        message = "Postal only";
                        break;
                    default:
                        message = "Unknown contact method selected";
                        break;
                }
            } else {
                message = "No contact method selected";
            }

            // Gán message vào request attribute để gửi tới JSP
            request.setAttribute("contact", message);
            url = "/thanks.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

}
