<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!-- COMPANY-FACALITY START -->
<section class="company-facality">
    <div class="container">
        <div class="row">
            <div class="company-facality-row">
                <!-- SINGLE-FACALITY START -->
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="single-facality">
                        <div class="facality-icon">
                            <i class="fa fa-rocket"></i>
                        </div>
                        <div class="facality-text">
                            <h3 class="facality-heading-text">Giao hàng nhanh</h3>
                            <span></span>
                        </div>
                    </div>
                </div>
                <!-- SINGLE-FACALITY END -->
                <!-- SINGLE-FACALITY START -->
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="single-facality">
                        <div class="facality-icon">
                            <i class="fa fa-umbrella"></i>
                        </div>
                        <div class="facality-text">
                            <h3 class="facality-heading-text">Hỗ trợ 24/7</h3>
                            <span></span>
                        </div>
                    </div>
                </div>
                <!-- SINGLE-FACALITY END -->
                <!-- SINGLE-FACALITY START -->
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <div class="single-facality">
                        <div class="facality-icon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <div class="facality-text">
                            <h3 class="facality-heading-text">Cập nhật hàng ngày</h3>
                            <span></span>
                        </div>
                    </div>
                </div>
                <!-- SINGLE-FACALITY END -->
            </div>
        </div>
    </div>
</section>
<!-- COMPANY-FACALITY END -->
<!-- FOOTER-TOP-AREA START -->
<section class="footer-top-area">
    <div class="container">
        <div class="footer-top-container">
            <div class="row">
                 <!-- FOOTER-TOP-RIGHT-1 START -->
                 <div class="footer-top-right-1">
                     <div class="row">
                         <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                         	<c:if test="${contact != null }">
                         		<!-- STORE-INFORMATION START -->
                              <div class="Store-Information">
                                  <h2>Thông tin liên hệ</h2>
                                  <ul>
                                  	<c:if test="${contact.address != null }">
                                  		 <li>
                                           <div class="info-lefticon">
                                               <i class="fa fa-map-marker"></i>
                                           </div>
                                           <div class="info-text" style="padding-top:10px;">
                                               <p>${contact.address }</p>
                                           </div>
                                       </li>
                                  	</c:if>
                                     <c:if test="${contact.phone != null }">
                                      <li>
                                           <div class="info-lefticon">
                                               <i class="fa fa-phone"></i>
                                           </div>
                                           <div class="info-text call-lh">
                                               <p>Số Điện Thoại: ${contact.phone }</p>
                                           </div>
                                       </li>
                                     </c:if>
                                      <c:if test="${contact.email != null }">
                                      	<li>
                                           <div class="info-lefticon">
                                               <i class="fa fa-envelope-o"></i>
                                           </div>
                                           <div class="info-text">
                                               <p>Email : <a href="mailto:${contact.email }"><i class="fa fa-angle-double-right"></i> ${contact.email }</a></p>
                                           </div>
                                      	</li>
                                      </c:if>
                                  </ul>
                              </div>
                              <!-- STORE-INFORMATION END -->
                         	</c:if>
                         </div>
                     </div>
                 </div>
            </div>
        </div>
    </div>
</section>
<!-- FOOTER-TOP-AREA END -->
<!-- COPYRIGHT-AREA START -->
<footer class="copyright-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="copy-right">
                    <address>Copyright © 2015 <a href="http://bootexperts.com/">BootExperts</a> All Rights Reserved</address>
                </div>
                <div class="scroll-to-top">
                    <a href="#" class="bstore-scrollertop"><i class="fa fa-angle-double-up"></i></a>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- COPYRIGHT-AREA END -->