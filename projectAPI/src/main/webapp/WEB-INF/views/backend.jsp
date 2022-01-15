<%--
  Created by IntelliJ IDEA.
  User: tu901
  Date: 28/11/2021
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="./header.jsp"/>
<body class="sb-nav-fixed">
<jsp:include page="./nav_top.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="./nav_sides.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Dashboard</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">Dashboard</li>
                </ol>
                <div class="row">
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-primary text-white mb-4">
                            <div class="card-body">Primary Card</div>
                            <div
                                    class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="#">View
                                    Details</a>
                                <div class="small text-white">
                                    <i class="fas fa-angle-right"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-warning text-white mb-4">
                            <div class="card-body">Warning Card</div>
                            <div
                                    class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="#">View
                                    Details</a>
                                <div class="small text-white">
                                    <i class="fas fa-angle-right"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-success text-white mb-4">
                            <div class="card-body">Success Card</div>
                            <div
                                    class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="#">View
                                    Details</a>
                                <div class="small text-white">
                                    <i class="fas fa-angle-right"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6">
                        <div class="card bg-danger text-white mb-4">
                            <div class="card-body">Danger Card</div>
                            <div
                                    class="card-footer d-flex align-items-center justify-content-between">
                                <a class="small text-white stretched-link" href="#">View
                                    Details</a>
                                <div class="small text-white">
                                    <i class="fas fa-angle-right"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i> DataTable Teacher
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Address</th>
                                <th>Picture</th>
                                <th>Phone Number</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Address</th>
                                <th>Picture</th>
                                <th>Phone Number</th>
                                <th>Action</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="teacher" items="${listTeacher}"
                                       varStatus="status">
                                <tr>
                                    <td>${teacher.getId()}</td>
                                    <td>${teacher.getName()}</td>
                                    <td>${teacher.getAge()}</td>
                                    <td>${teacher.getAddress()}</td>
                                    <td>${teacher.getPicture()}</td>
                                    <td>${teacher.getSdt()}</td>
                                    <td>
                                        <a href="#"><i class="fa fa-eye" aria-hMaGVden="true"></i></a>
                                        <a href="/projectAPI_war/admin/teachers/update?id=${teacher.getId()}"><i
                                                class="fa fa-retweet" aria-hMaGVden="true"></i></a>
                                        <a href="/projectAPI_war/admin/teachers/delete?id=${teacher.getId()}"
                                           onclick="return confirm('Are you sure about that ?')"><i class="fa fa-trash"
                                                                                                    aria-hMaGVden="true"></i></a>

                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i> DataTable Student
                    </div>
                    <div class="card-body">
                        <table id="datatablesStudent">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Address</th>
                                <th>Class ID</th>
                                <th>Picture</th>
                                <th>Phone Number</th>
                                <th>Actions</th>

                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Address</th>
                                <th>Class ID</th>
                                <th>Picture</th>
                                <th>Phone Number</th>
                                <th>Actions</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="student" items="${listStudents}"
                                       varStatus="status">
                                <tr>
                                    <td>${student.getId()}</td>
                                    <td>${student.getName()}</td>
                                    <td>${student.getAge()}</td>
                                    <td>${student.getAddress()}</td>
                                    <td>${student.getClassId()}</td>
                                    <td>${student.getPicture()}</td>
                                    <td>${student.getSdt()}</td>
                                    <td>
                                        <a  href="#"><i class="fa fa-eye" aria-hMaGVden="true"></i></a>
                                        <a  href="/projectAPI_war/admin/students/update/${student.getId()}"><i class="fa fa-retweet" aria-hMaGVden="true"></i></a>
                                        <a  href="/projectAPI_war/admin/students/delete/${student.getId()}" onclick="return confirm('Are you sure about that ?')"><i class="fa fa-trash" aria-hMaGVden="true"></i></a>

                                    </td>
                                </tr>

                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="./footer.jsp"/>
</body>
</html>