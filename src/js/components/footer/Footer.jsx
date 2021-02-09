import React from 'react';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faFacebookF } from '@fortawesome/free-brands-svg-icons'; 

library.add(faFacebookF); 
const Footer = () => (
  <div id="footer">
    <footer>
        <div className="container wow fadeInUp">
          <div className="row">
            <div className="col-sm-12 col-md-4"> 
              <h4>ABOUT Smart IT Tech</h4>
              <p>Smart IT Tech Interactive is a full-service Digital Media Marketing agency that lives and breathes “outside the box”. 
                  We have a team of Digital Media Marketing experts who catch those pure gold ideas and transform them into reality. A key reason why we are confident about delivering the results is that we have the best ability in each advanced channel.
                  Web designing,Web development,SEO Services.
              </p>
            </div>
            <div className="col-sm-12 col-md-2">
              <h4>USEFUL LINKS</h4>
              <ul className="footer-menu fa-ul">
                  <li><a href="#"><i className="fa-li fa fa-check" /> Home</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> About Us</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> Services</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> Pricing</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> Portfolio</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> Contact Us</a></li>
              </ul> 
            </div>
            <div className="col-sm-12 col-md-3">
              <h4>OUR SERVICES</h4>
              <ul className="footer-menu fa-ul">
                  <li><a href="#"><i className="fa-li fa fa-check" /> Website Design</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> Web Development</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> Mobile App Development</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> E-commerce Web Development</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" />Search Engine Optimization</a></li>
                  <li><a href="#"><i className="fa-li fa fa-check" /> Logo Design</a></li>
              </ul>
            </div>
            <div className="col-md-3">
              <h4>CONTACT DETAILS</h4>
              <p>Ahmad Afzal, Street E Block W House 28 New Satellite town Sargodha - Pakistan</p>
              <p><strong>Timing :</strong> Mon-Sat, 10:00am until 05:00pm</p>
              <p><strong>Email :</strong> ahmad.ramay4@gmail.com</p>
              <p><strong>Phone :</strong> 03407101829</p>
                <ul className="list-inline list-social">
                  <li id="fb"><a href="https://web.facebook.com/smart.it.teh" rel="noopener noreferrer" target="_blank"><i className="fab fa-facebook-f" aria-hidden="true" /></a> </li>
                  <li id="inst"><a href="https://instagram.com" rel="noopener noreferrer" target="_blank"><i className="fab fa-instagram" /></a></li>
                  <li id="tw"><a href="https://twitter.com/Ramay4A" rel="noopener noreferrer" target="_blank"><i className="fab fa-twitter" aria-hidden="true" /></a></li>
                  <li id="in"><a href="https://aboutme.google.com/u/0/?referer=gplus" rel="noopener noreferrer" target="_blank"><i className="fab fa-linkedin-in" /></a></li>          
                </ul>
            </div>
          </div>
        </div>
        
        <div className="float-sm">
          <div className="fl-fl float-fb">
          <i className="fab fa-facebook-f" />
          <a href="https://web.facebook.com/smart.it.teh" rel="noopener noreferrer" target="_blank"> Like us!</a>
          </div>
          <div className="fl-fl float-tw">
            <i className="fab fa-twitter" />
            <a href="https://twitter.com/Ramay4A" rel="noopener noreferrer" target="_blank"> Follow us!</a>
          </div>
        </div>
    </footer>
    <div className="sub-footer">
      <div className="container">
      <div className="row">
        <div className="col-md-6">
          <h6>Copyright © 2020 Smart IT Tech All Rights Reserved.</h6>
        </div>
        <div className="col-md-6">
          <h6>Designed and Developed by Team <b>LOGODESIGNER</b></h6>
        </div>
      </div>
        <div className="pull-right-1">
        <a href="#" className="back-to-top"><i className="fa fa-chevron-up" /></a>
        </div>
      </div>
    </div>
  </div>
  
  );

export default Footer;