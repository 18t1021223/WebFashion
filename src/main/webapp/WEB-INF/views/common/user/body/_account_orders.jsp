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
				<div class="account-info">
					<div class="single-account-info">
						<ul>
							<li><a href="/my-account-info.html"><i
									class="fa fa-user"></i><span>Thông tin cá nhân</span> </a></li>
							<li><a href="#"><i class="fa fa-building"></i><span>Địa
										chỉ</span></a></li>
							<li><a href="#"><i class="fa fa-list-ol"></i><span>Đơn
										mua</span> </a></li>
							<li><a href="#"><i class="fa fa-file-o"></i><span>My
										credit slips</span> </a></li>

						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<!-- <div class="alert alert-success" role="alert">
                                <p><i class="fa fa-check"></i> Cập nhật thành công</p>
                            </div> -->
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<!-- CART TABLE_BLOCK START -->
						<div class="table-responsive">
							<!-- TABLE START -->
							<table class="table table-bordered" id="cart-summary">
								<!-- TABLE HEADER START -->
								<thead>
									<tr>
										<th class="cart-product">Ngày mua</th>
										<th class="cart-description">Sản phẩm</th>
										<th class="cart-unit text-right">Tổng tiền</th>
										<th class="cart-total text-right">Trạng thái</th>
										<th></th>
									</tr>
								</thead>
								<!-- TABLE HEADER END -->
								<!-- TABLE BODY START -->
								<tbody>
									<!-- SINGLE CART_ITEM START -->
									<tr>
										<td class="cart-time">
											<p>25-12-2000 12:23</p>
										</td>
										<td class="cart-description">
											<p class="product-name">
												<a href="#">Faded Short Sleeves</a>
											</p> <span>...và 5 sản phẩm khác</span>
										</td>

										<td class="cart-unit">
											<ul class="price text-right">
												<li class="price">150.000 đ</li>
											</ul>
										</td>
										<td class="cart-total"><span class="price">da hoan
												thanh</span></td>
										<td><a href="/my-account-orderDetails.html"><i
												class="fa fa-eye"></i></a></td>
									</tr>
									<!-- SINGLE CART_ITEM END -->
									<!-- SINGLE CART_ITEM START -->
									<tr>
										<td class="cart-time">
											<p>25-12-2000 12:23</p>
										</td>
										<td class="cart-description">
											<p class="product-name">
												<a href="#">Faded Short Sleeves</a>
											</p> <span>...và 5 sản phẩm khác</span>
										</td>

										<td class="cart-unit">
											<ul class="price text-right">
												<li class="price">150.000 đ</li>
											</ul>
										</td>
										<td class="cart-total"><span class="price">da hoan
												thanh</span></td>
										<td><a href="/my-account-orderDetails.html"><i
												class="fa fa-eye"></i></a></td>
									</tr>
									<!-- SINGLE CART_ITEM END -->
								</tbody>
								<!-- TABLE BODY END -->
							</table>
							<!-- TABLE END -->
						</div>
						<!-- CART TABLE_BLOCK END -->
					</div>
				</div>
			</div>
			<!-- ACCOUNT-INFO-TEXT END -->
		</div>
	</div>
</section>
<!-- MAIN-CONTENT-SECTION END -->
