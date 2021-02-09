// ########## Import Dependencies Here ##########
import React, { Component } from 'react';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faFacebookF } from '@fortawesome/free-brands-svg-icons'; 

library.add(faFacebookF);


// ########## Import Screens Here ##########

// ########## Import Components Here ##########

export default class Team extends Component {
  
  componentDidMount() {

  }
  render() {
    return (
      <section id="team">
        <div className="container">
            <div className="section-header wow fadeInUp">
                <h3>Team</h3>
            </div>
            <div className="row">
                <div className="col-lg-3 col-md-6 wow fadeInUp">
                 <div className="member">
                    <img src="../images/Home/ahmad.jpg" className="img-fluid" alt="" />
                  <div className="member-info">
                   <div className="member-info-content">
                        <h4>Ahmad Chaudhary</h4>
                        <span>CEO</span>
                    <div className="social">
                        <a href="https://web.facebook.com/smart.it.teh" rel="noopener noreferrer" target="_blank"><i className="fab fa-facebook-square" /></a>
                        <a href="https://instagram.com" rel="noopener noreferrer" target="_blank"><i className="fab fa-instagram" /></a>
                        <a href="https://twitter.com/https:/home" rel="noopener noreferrer" target="_blank"><i className="fab fa-twitter-square" /></a>
                        <a href="https://aboutme.google.com/u/0/?referer=gplus" rel="noopener noreferrer" target="_blank"><i className="fab fa-google-plus-square" /></a>
                    </div>
                   </div>
                  </div>
                 </div>
                </div>
                <div className="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                 <div className="member">
                    <img src="../images/Home/awais.jpg" className="img-fluid" alt="" />
                  <div className="member-info">
                    <div className="member-info-content">
                        <h4>Awais</h4>
                        <span>Product Manager</span>
                     <div className="social">
                        <a href="https://web.facebook.com/smart.it.teh" rel="noopener noreferrer" target="_blank"><i className="fab fa-facebook-square" /></a>
                        <a href="https://instagram.com" rel="noopener noreferrer" target="_blank"><i className="fab fa-instagram" /></a>
                        <a href="https://twitter.com/https:/home" rel="noopener noreferrer" target="_blank"><i className="fab fa-twitter-square" /></a>
                        <a href="https://aboutme.google.com/u/0/?referer=gplus" rel="noopener noreferrer" target="_blank"><i className="fab fa-google-plus-square" /></a>
                     </div>
                    </div>
                  </div>
                 </div>
                </div>
                <div className="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
                 <div className="member">
                    <img src="../images/Home/amna.jpeg" className="img-fluid" alt="" />
                  <div className="member-info">
                    <div className="member-info-content">
                        <h4>Amna Tallat</h4>
                        <span>Senior Graphic Designer</span>
                     <div className="social">
                        <a href="https://web.facebook.com/smart.it.teh" rel="noopener noreferrer" target="_blank"><i className="fab fa-facebook-square" /></a>
                        <a href="https://instagram.com" rel="noopener noreferrer" target="_blank"><i className="fab fa-instagram" /></a>
                        <a href="https://twitter.com/https:/home" rel="noopener noreferrer" target="_blank"><i className="fab fa-twitter-square" /></a>
                        <a href="https://aboutme.google.com/u/0/?referer=gplus" rel="noopener noreferrer" target="_blank"><i className="fab fa-google-plus-square" /></a>
                     </div>
                    
                    </div>
                  </div>
                 </div>
                </div>
                <div className="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                 <div className="member">
                    <img src="../images/Home/Hamza.jpg" className="img-fluid" alt="" />
                  <div className="member-info">
                    <div className="member-info-content">
                        <h4>Hamza Asharaf</h4>
                        <span>Chief Executive Officer</span>
                     <div className="social">
                        <a href="https://web.facebook.com/smart.it.teh" rel="noopener noreferrer" target="_blank"><i className="fab fa-facebook-square" /></a>
                        <a href="https://instagram.com" rel="noopener noreferrer" target="_blank"><i className="fab fa-instagram" /></a>
                        <a href="https://twitter.com/https:/home" rel="noopener noreferrer" target="_blank"><i className="fab fa-twitter-square" /></a>
                        <a href="https://aboutme.google.com/u/0/?referer=gplus" rel="noopener noreferrer" target="_blank"><i className="fab fa-google-plus-square" /></a>
                     </div>
                    </div>
                  </div>
                 </div>
                </div>
            </div>
        </div>
      </section> 
    );
  };
}

Team.propTypes = {
}