<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<title>Liên hệ</title>
<!-- MAIN-CONTENT-SECTION START -->
<section class="main-content-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <!-- BSTORE-BREADCRUMB START -->
                <div class="bstore-breadcrumb">
                    <a href="<c:url value="/home"/>">Trang chủ</a>
                    <span><i class="fa fa-caret-right"></i></span>
                    <span>Liên hệ</span>
                </div>
                <!-- BSTORE-BREADCRUMB END -->
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h2 class="page-title contant-page-title">Phản hồi của khách hàng</h2>
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <!-- CONTACT-US-FORM START -->
                <div class="contact-us-form">
                    <div class="contact-form-center">
                        <h3 class="contact-subheading">Gửi tin nhắn</h3>
                        <!-- CONTACT-FORM START -->
                        <form class="contact-form" id="contactForm" method="post" action="#">
                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
                                    <div class="form-group primary-form-group">
                                        <label>Tiêu đề</label>
                                        <div class="con-form-select">
                                            <select id="conForm" name="conform">
                                                <option value="">Pnản hồi - đánh giá</option>
                                                <option value="">Webmaster</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group primary-form-group">
                                        <label>Email</label>
                                        <input type="email" class="form-control input-feild" id="contactEmail" name="contactemail" value="">
                                    </div>
                                    <button type="submit" name="submit" id="sendMessage" class="send-message main-btn">Gủi <i class="fa fa-chevron-right"></i></button>
                                </div>
                                <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
                                    <div class="type-of-text">
                                        <div class="form-group primary-form-group">
                                            <label>Message</label>
                                            <textarea class="contact-text" name="ContactMessage"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <!-- CONTACT-FORM END -->
                    </div>
                </div>
                <!-- CONTACT-US-FORM END -->
            </div>
        </div>
    </div>
</section>
<!-- MAIN-CONTENT-SECTION END -->