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
					<a href="index.html">Trang chủ</a> <span><i
						class="fa fa-caret-right"></i></span> <span>Tài khoản</span>
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
					<div class="col-lg-12 col-md-6 clo-sm-12 col-xs-12">
						<!-- <div class="alert alert-danger" role="alert">
                                <p><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Cập nhật thất bại</p>
                            </div> -->
					</div>
					<div class="col-lg-12 col-md-12 clo-sm-12 col-xs-12">
						<div style="margin: 20px 0;">
							<p>
								<a class="" data-toggle="collapse" href="#createAddress"
									aria-expanded="false" aria-controls="contentId"> Thêm địa
									chỉ mới <i class="fa fa-plus"></i>
								</a>
							</p>
							<div class="collapse" id="createAddress">
								<form action="#" method="post" id=''>
									<div class="form-group">
										<input type="text" class="form-control address_user"
											name="address_user" placeholder="Họ tên" required> <small
											id="nameHelpId" class="form-text text-muted"></small>
									</div>
									<div class="form-group">
										<input type="text" class="form-control address_telephone"
											name='address_telephone' placeholder="Số điện thoại" required
											minlength="9"> <small id="telephoneHelpId"
											class="form-text text-muted"></small>
									</div>
									<div class="form-group">
										<select class="form-control mb-4 province" name="province"
											required>
											<option hidden value=''>Tỉnh/thành phố</option>
										</select>
									</div>

									<div class="form-group">
										<select class="form-control mb-4 district" name='district'
											required>
											<option hidden value="">Quận/huyện</option>
										</select>
									</div>

									<div class="form-group">
										<select class="form-control mb-4 ward" name='ward' required>
											<option hidden value="">Phường/xã</option>
										</select>
									</div>
									<div class="form-group">
										<textarea name="" placeholder="Đường/phố" class="" rows="3"
											required="required" style="width: 100%;"></textarea>
									</div>
									<div class="modal-footer">
										<a class="btn btn-danger" data-toggle="collapse"
											href="#createAddress" aria-expanded="false"
											aria-controls="contentId"> Huỷ </a> <input type="submit"
											class="btn btn-primary" value="Lưu">
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
						<div class="primari-box">
							<!-- DELIVERY ADDRESS START -->
							<div class="Store-Information">
								<ul>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-user"></i>
										</div>
										<div class="info-text call-lh">
											<p>Họ tên: Phạm Anh Nhật.</p>
										</div>
									</li>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-map-marker"></i>
										</div>
										<div class="info-text">
											<p>My Company, 42 avenue des Champs Elysées 75000 Paris
												France</p>
										</div>
									</li>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-phone"></i>
										</div>
										<div class="info-text call-lh">
											<p>Điện thoại: 0123-456-789</p>
										</div>
									</li>
									<li class="address-btn"><a href="#" class="btn btn-danger">Xóa</a>
									</li>
								</ul>
							</div>
							<!-- DELIVERY ADDRESS END -->
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
						<div class="primari-box">
							<!-- DELIVERY ADDRESS START -->
							<div class="Store-Information">
								<ul>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-user"></i>
										</div>
										<div class="info-text call-lh">
											<p>Họ tên: Phạm Anh Nhật.</p>
										</div>
									</li>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-map-marker"></i>
										</div>
										<div class="info-text">
											<p>My Company, 42 avenue des Champs Elysées 75000 Paris
												France</p>
										</div>
									</li>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-phone"></i>
										</div>
										<div class="info-text call-lh">
											<p>Điện thoại: 0123-456-789</p>
										</div>
									</li>
									<li class="address-btn"><a href="#" class="btn btn-danger">Xóa</a>
									</li>
								</ul>
							</div>
							<!-- DELIVERY ADDRESS END -->
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
						<div class="primari-box">
							<!-- DELIVERY ADDRESS START -->
							<div class="Store-Information">
								<ul>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-user"></i>
										</div>
										<div class="info-text call-lh">
											<p>Họ tên: Phạm Anh Nhật.</p>
										</div>
									</li>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-map-marker"></i>
										</div>
										<div class="info-text">
											<p>My Company, 42 avenue des Champs Elysées 75000 Paris
												France</p>
										</div>
									</li>
									<li>
										<div class="info-lefticon">
											<i class="fa fa-phone"></i>
										</div>
										<div class="info-text call-lh">
											<p>Điện thoại: 0123-456-789</p>
										</div>
									</li>
									<li class="address-btn"><a href="#" class="btn btn-danger">Xóa</a>
									</li>
								</ul>
							</div>
							<!-- DELIVERY ADDRESS END -->
						</div>
					</div>
				</div>
			</div>
			<!-- ACCOUNT-INFO-TEXT END -->
		</div>
	</div>
</section>
<!-- MAIN-CONTENT-SECTION END -->