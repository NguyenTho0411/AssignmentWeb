<%-- 
    Document   : thanks
    Created on : Sep 12, 2024, 11:04:12 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <title>22110237-Nguyễn Hữu Đức Thọ</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Thanks for joining our email list</h1>
        <p>Here is the imformation that you entered:</p>

        <label class="classes">Email:</label>
        <span>${user.email}</span> <br>
        <label class="classes">First Name:</label>
        <span>${user.firstName}</span> <br>
        <label class="classes">Last Name:</label>
        <span>${user.lastName}</span> <br>
        <label class="classes">Date of Birth:</label>
        <span>${user.birthDate}</span> <br>
        <label class="classes">How did i hear:</label>
        <span>${hear}</span> <br>
        <label class="classes">Announcement Option:</label>
        <span>${receive}</span> <br>
        <label class="classes">Contact Option:</label>
        <span>${contact}</span> <br>
        <p> To enter another imformation,click on the <b>Back button</b> in your browser or
            the <b>Return button</b> shown below</p>
        <form action="" method="get">
            <input type="hidden" name="action" value="join"><!-- comment -->
            <input type="submit" value="Return">
        </form>
    </form>
</body>
</html>
