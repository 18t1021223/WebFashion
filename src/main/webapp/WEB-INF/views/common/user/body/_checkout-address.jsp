<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<title>Địa chỉ nhận hàng</title>
<!-- MAIN-CONTENT-SECTION START -->
<section class="main-content-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<!-- BSTORE-BREADCRUMB START -->
				<div class="bstore-breadcrumb">
					<a href="<c:url value='/home'/>">Trang chủ</a> <span><i
						class="fa fa-caret-right"></i></span> <span>Địa chỉ</span>
				</div>
				<!-- BSTORE-BREADCRUMB END -->
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<h2 class="page-title">Địa chỉ giao hàng</h2>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<!-- SHOPING-CART-MENU START -->
				<div class="shoping-cart-menu">
					<ul class="step">
						<li class="step-todo first step-done"><span><a
								href="<c:url value='/cart'/>">01. Giỏ hàng</a></span></li>
						<li class="step-current second"><span>02. Địa chỉ</span></li>
						<li class="step-todo last" id="step_end"><span>03.Thanh
								toán</span></li>
					</ul>
				</div>
				<!-- SHOPING-CART-MENU END -->
			</div>

		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="primari-box">
					<!-- DELIVERY ADDRESS START -->
					<div class="form-address">
						<h2 style="text-align: center;margin-bottom:30px;">Địa chỉ nhận hàng</h2>
						<form:form action="/cart/checkout-details" method="POST" id='info-address' modelAttribute="toAddress">
							<label for="name">Họ Và Tên *</label> 
							<form:input path="name" id="name" type="text" placeholder="Nhập họ và tên..."/>
							<form:errors path="name" cssClass="check-error"/>
							<br>
							<label for="phone">Số Điện Thoại*</label> 
							<form:input type="text" id="phone" path="phone" placeholder="Nhập số điện thoại..."/> 
							<form:errors path="phone" cssClass="check-error"/>
							<br>
							<form:select path="province" name="province" id="province">
								<c:if test="${district == null}">
									<option hidden value="">Tỉnh/Thành phố *</option>
								</c:if>
								<c:forEach var="item" items="${province }">
									<c:if test="${provinceSelected == item.provinceId }">
										<form:option  value="${item.provinceId }" selected='true'>${item.provinceName}</form:option>
									</c:if>
									<c:if test="${provinceSelected != item.provinceId }">
										<form:option  value="${item.provinceId }">${item.provinceName}</form:option>
									</c:if>
								</c:forEach>
							</form:select>
							
							<form:select id="district" name="district" path="district">
								<c:if test="${district == null}">
									<option hidden value="">Quận/Huyện *</option>
								</c:if>
								<c:forEach var="item" items="${district }">
									<c:if test="${item.districtId == districtSelected }">
										<form:option value="${item.districtId }" selected='true'>${item.districtName}</form:option>
									</c:if>
									<c:if test="${item.districtId != districtSelected }">
										<form:option value="${item.districtId }">${item.districtName}</form:option>
									</c:if>
									
								</c:forEach>
							</form:select>

							<form:select id="ward" name="ward" path="ward">
								<c:if test="${ward == null }">
									<option hidden value="">Phường/Xã *</option>
								</c:if>
								<c:forEach var="item" items="${ward }">
									<c:choose>
										<c:when test="${item.wardId == wardSelected }">
											<form:option value="${item.wardId }" selected='true'>${item.wardName}</form:option>
										</c:when>
										<c:otherwise>
											<form:option value="${item.wardId }">${item.wardName}</form:option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
							<form:textarea path="street" name="street" id="street" rows="2"
								style="width: 100%; resize: none; padding: 9px;"
								placeholder="số nhà..."/>
							<form:errors path="street" cssClass="check-error"/>	
						</form:form>
					</div>
					<!-- DELIVERY ADDRESS END -->
				</div>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<!-- RETURNE-CONTINUE-SHOP START -->
				<div class="returne-continue-shop ship-address">
					<a href="<c:url value='/home'/>" class="continueshoping">
						<i class="fa fa-chevron-left"></i>Tiếp tục mua sắm
					</a> 
					<a href="#" class="address procedtocheckout">Tiếp tục
						<i class="fa fa-chevron-right"></i> </a>
				</div>
				<!-- RETURNE-CONTINUE-SHOP END -->
			</div>
		</div>
	</div>
</section>
<!-- MAIN-CONTENT-SECTION END -->

