<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="resources/css/mainCSS.css">
</head>
<body>
<header>
    <section id="gnb">
        <img src="resources/img/spr_header.png" width=200px alt="error">
        <p>crong@edwith.or.kr</p>
    </section>
</header>

<section id="promotion">
    <article class="animation">
        <script id="template-list-promotion" type="text/template">
            <img src="resources/{url}" class="slideImage" alt="img">
        </script>
    </article>

    <nav id="category">
        <ul class=buttonUl>
            <script id="template-list-category" type="text/template">
                <li id="{id}" class="button">{name}</li>
            </script>
        </ul>
    </nav>

    <article class="count">
        <p>바로 예매 가능한 행사가 <span class="categoryCount"></span> 있습니다</p>
    </article>
</section>

<section id="info">
    <section id="leftSection"></section>
    <section id="rightSection"></section>
    <script id="template-list-product" type="text/template">
        <img src="resources/{url}" class="infoImage" alt="img">
        <div class="description">
            <p class="descriptionHead">{description}</p>
            <p class="place">{place}</p>
        </div>
        <div class="content">
            {content}
        </div>
    </script>
    <div class="dummy"></div>
</section>

<section id="additionalMenu">
    <script id="template-list-viewmore" type="text/template">
        <div class="viewMoreBox">더보기</div>
    </script>
</section>

<p class="topButton"><a href="#">↑TOP</a></p>

<footer>
    <p>네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
    <p class="copyright">(주)네이버 사업자정보 </p>
    <span>이용약관 | </span>
    <span class="infoPolicy">개인정보처리방침 |</span>
    <span> 네이버 예약 고객센터</span>
    <p>ⓒ NAVER Corp.</p>
</footer>

<script type="text/javascript" src="resources/js/animation.js"></script>
<script type="text/javascript" src="resources/js/main.js"></script>
</body>
</html>