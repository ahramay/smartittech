// ########## Import Dependencies Here ##########
import React, { Component } from 'react';
// import PropTypes from 'prop-types';

// ########## Import Screens Here ##########

// ########## Import Components Here ##########
// import ReadMoreButton from './ReadMoreButton';

export default class JuniorSchool extends Component {

  componentDidMount() {

  }

  render() {
    return (
      <section className="services-page pad-bottom-0">
        <div className="container">
            <div className="row">
              <div className="col-md-12">
                  <div className="col-md-7">
                    <div className="services-left wow fadeInUp animated animated">
                      <h3>   WANT TO ENJOY THE PROFESSIONAL WEB DESIGNING SERVICES? SMART IT
                            TECH IS HERE TO GIVE YOU AN INTUITIVE WEB DESIGN EXPERIENCE.
                      </h3>
                      <p>When you hire our web designers, then you could expect the high-quality work from us as we can provide the customized solution for any type of business website including the fashion, food or even the e-commerce websites. You can also ask us for the graphic designing, logo designing, colour selection for your website, font selection or the additional features to be incorporated in your website; we can do all for your website. We ask you about your brand and your requirements and then start working on your website to provide you with the exciting web designs.</p>
                    </div>
                  </div>
                <div className="col-md-5">
                  <div className="carousel">
                    <div className="item">
                      <img classNameName="mockeup" src="../images/Home/Untitled-2.png" alt="First slide" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="row">
                <div className="col-md-6"> 
                    <div className="services-right wow fadeInRight animated animated">
                    <img classNameName="img-responsive" src="../images/Home/Untitled-3.png" alt="web-services" />
                    </div>
                </div>
                <div className="col-md-6">
                    <div className="services-left wow fadeInUp animated animated">
                      <h2>Hire the web developers that can help you to increase your ROIs by making your websites competitive</h2>
                      <p>Once we have designed your website, it’s time to proceed towards the development process. Looks are necessary, but if your website is not getting the traffic, then it means you need to head towards the direction that would be pushing the traffic towards your website. We can allow you to get the maximum traffic at your website as we have the best website developers in our team who make it sure that our customers are pleased to see the final look of their website. Our web development team is fully trained having the knowledge related to the latest technologies. We want to make the whole process of development easy and convenient for you.</p>
                    </div>
                </div>
            </div>        
        </div>
      </section>
    );
  }
}

JuniorSchool.propTypes = {
}
