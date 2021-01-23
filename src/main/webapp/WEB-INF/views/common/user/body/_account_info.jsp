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
                        <span>Tài khoản</span>
                    </div>
                    <!-- BSTORE-BREADCRUMB END -->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h2 class="page-title">Tài khoản của bạn</h2>
                </div>

                <!-- ACCOUNT-INFO-TEXT START -->
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                   <%@ include file="/WEB-INF/views/common/user/base/siderbar.jsp" %>
                </div>
                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="alert alert-success" role="alert">
                                <p><i class="fa fa-check"></i> Cập nhật thành công</p>
                                <!-- <i class="fa fa-exclamation-triangle" aria-hidden="true"></i> -->
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                            <form action="" method="post">
                                <div class="form-group">
                                    <label for="">Họ tên</label>
                                    <input type="text" name="" id="" class="form-control" placeholder="" aria-describedby="helpId" required>
                                    <small id="helpId" class="text-muted"></small>
                                </div>

                                <div class="form-group">
                                    <label for="">Email</label>
                                    <input type="email" class="form-control" name="" id="" aria-describedby="emailHelpId" placeholder="" readonly>
                                    <small id="emailHelpId" class="form-text text-muted"></small>
                                </div>
                                <p>
                                    <a class="" data-toggle="collapse" href="#contentId" aria-expanded="false" aria-controls="contentId">
										Thay đổi mật khẩu
									</a>
                                </p>
                                <div class="collapse" id="contentId">
                                    <div class="form-group">
                                        <label for="">Mật khẩu hiện tại</label>
                                        <input type="password" class="form-control" name="" id="" placeholder="">
                                    </div>
                                    <div class="form-group">
                                        <label for="">Mật khẩu mới</label>
                                        <input type="password" class="form-control" name="" id="" placeholder="Mật khẩu mới ít nhất 8 ký tự" minlength="8">
                                    </div>
                                    <div class="form-group">
                                        <label for="">Nhập lại mật khẩu mới</label>
                                        <input type="password" class="form-control" name="" id="" placeholder="">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-warning">Cập nhật</button>
                            </form>

                        </div>
                    </div>

                </div>
                <!-- ACCOUNT-INFO-TEXT END -->
            </div>
        </div>
    </section>
    <!-- MAIN-CONTENT-SECTION END -->