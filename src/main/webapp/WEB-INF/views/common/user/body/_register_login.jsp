<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!-- MAIN-CONTENT-SECTION START -->
    <section class="main-content-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <!-- BSTORE-BREADCRUMB START -->
                    <div class="bstore-breadcrumb">
                        <a href="index.html">Trang chủ</a>
                        <span><i class="fa fa-caret-right"></i></span>
                        <span>Đăng nhập / Đăng ký</span>
                    </div>
                    <!-- BSTORE-BREADCRUMB END -->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h2 class="page-title">Đăng nhập / Đăng ký</h2>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <!-- CREATE-NEW-ACCOUNT START -->
                    <div class="create-new-account">
                        <form class="new-account-box primari-box" id="create-new-account" method="post" action="#">
                            <h3 class="box-subheading">Tạo tài khoản</h3>
                            <div class="form-content">
                                <p>Vui lòng nhập địa chỉ email của bạn để tạo tài khoản.</p>
                                <div class="form-group primary-form-group">
                                    <label for="email">Email</label>
                                    <input type="text" value="" name="email" id="email" class="form-control input-feild" required>
                                </div>
                                <div class="submit-button">
                                    <a href="checkout-registration.html" id="SubmitCreate" class="btn main-btn">
                                        <span>
												<i class="fa fa-user submit-icon"></i>
												Xác nhận
											</span>
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- CREATE-NEW-ACCOUNT END -->
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <!-- login-ACCOUNT START -->
                    <div class="primari-box registered-account">
                        <form class="new-account-box" id="accountLogin" method="post" action="#">
                            <h3 class="box-subheading">Đăng nhập</h3>
                            <div class="form-content">
                                <div class="form-group primary-form-group">
                                    <label for="loginemail">Email</label>
                                    <input type="text" value="" name="email" id="loginemail" class="form-control input-feild">
                                </div>
                                <div class="form-group primary-form-group">
                                    <label for="password">Mật khẩu</label>
                                    <input type="password" value="" name="password" id="password" class="form-control input-feild">
                                </div>
                                <div class="forget-password">
                                    <p><a href="#">Quên mật khẩu?</a></p>
                                </div>
                                <div class="submit-button">
                                    <a href="my-account.html" id="signinCreate" class="btn main-btn">
                                        <span>
											<i class="fa fa-lock submit-icon"></i>
											 Đăng nhập
										</span>
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- login-ACCOUNT END -->
                </div>
            </div>
        </div>
    </section>
    <!-- MAIN-CONTENT-SECTION END -->