<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 23.08.2022
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Введите имя:</h2>
    <br>
    <br>
    <%--<form:form action="showDetails" modelAttribute="employee">
        Name <form:input path="name"></form:input> <br><br>
        Surname <form:input path="surname"/> <br><br>
        Salary <form:input path="salary"/>

        <input type="submit" value="OK">
    </form:form>
    --%>

    <div class="container mt-5 mb-5">
        <h1>Edit info</h1>
        <!--    <form action="/profile1/edit" method="post">-->

        <form class="js-form" method="post">
            <input type="tel" th:value="${el.tel}" name="tel" placeholder="Enter your phone" class="form-control form-control-phone" ><br>
            <input type="text" th:value="${el.firstName}"name="firstName" placeholder="Enter your lastname" class="form-control" ><br>
            <input type="text" th:value="${el.lastName}"name="lastName" placeholder="Enter your lastname" class="form-control" ><br>
            <input type="email" th:value="${el.email}"name="email" placeholder="Enter your email" class="form-control form-control-email" ><br>
            <textarea name="about" placeholder="Enter text about you" class="form-control" th:text="${el.about}"></textarea><br>
            <button type="submit">Update info</button>
        </form>


    </div>

    <script>
        let form = document.querySelector('.js-form'),
            formInputs = document.querySelectorAll('.form-control'),
            inputEmail = form.querySelector('.form-control-email')
            inputPhone = form.querySelector('.form-control-phone');

        function validateEmail(email) {
            let re = /[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+/;
            return re.test(String(email).toLowerCase());
        }

        function validatePhone(phone) {
            let re = /^[0-9\s]*$/;
            return re.test(String(phone));
        }

        form.onsubmit = function () {
            let emailVal = inputEmail.value,
                phoneVal = inputPhone.value,
                emptyInputs = Array.from(formInputs).filter(input => input.value === '');

            formInputs.forEach(function (input) {
                if (input.value === '') {
                    input.style.borderColor = 'red';
                } else {
                    input.style.bordercolor = 'gray';
                }
            })

            if (emptyInputs.length !== 0) {
                console.log('inputs not filled');
                return false;
            }

            if (!validatePhone(phoneVal)) {
                console.log('phone not valid');
                inputPhone.style.borderColor = 'red'
                return false;
            } else {
                inputPhone.style.bordercolor = 'gray';
            }

            if(!validateEmail(emailVal)) {
                console.log('email not valid');
                inputEmail.style.borderColor = 'red'
                return false;
            } else {
                inputEmail.style.bordercolor = 'gray';
            }
        }
    </script>
</body>
</html>
