import React from 'react';

class Gallery extends React.Component {

  componentDidMount(){

  }
  render() {
    return (
      <div className="home">
        <div className="about">
          <div className="hero-img" data-aos="fade-left" data-aos-delay="200">
            <img  src="./images/about-img.png" className="img-fluid animated" alt="" />
          </div>
           <div className="about-IT">
            <h4>About Us</h4>
              <p>
                Smart IT Tech Interactive is a full-service Digital Media Marketing
                agency that lives and breathes “outside the box”.
                We have a team of Digital Media Marketing experts who catch those pure
                gold ideas and transform them into reality. A key reason why we are confident
                about delivering the results is that we have the best ability in each advanced future.
              </p>
            <a href="#" className="more-link">Read more</a>
           </div>
           <div className="box">
              <div className="box">.</div>
              <div className="box">.</div>
              <div className="box">.</div>
              <div className="box">.</div>
              <div className="box">.</div>
              <div className="box">.</div>
              <div className="box">.</div>
              <div className="box">.</div>
              <div className="box">.</div>
              <div className="box">.</div>
           </div>
        </div>
        <section className="service-page pad-bottom-0">
          <div className="container">
              <div className="row">
                  <div className="col-sm-12">
                    <div className="service-title text-center">
                      <h1>WE ARE LEADING WEBSITE DESIGN COMPANY THAT CAN BUILD A STRONG</h1>
                        <h1 className='website-item'>ARCHITECTURE FOR YOUR WEBSITE</h1>
                        <h2>...</h2>
                    </div>
                  </div>
                  <div className="col-md-12">
                      <div className="service-left wow fadeInUp animated animated">
                        <p> Smart IT TECH is the reliable and the trustworthy name in the
                            world of web development and have helped a number of brands in
                            designing and developing their website. Whether it comes to the
                            CMS web design or it is about the different types of web
                            development like Custom React, React-redux development &
                            e-commerce web development we can Fulfil All your needs.
                        </p>
                        <h2>
                          YOUR WEB SITE IS IMPORTANT, WITH SMIRT IT TECH BOOST YOUR BUSINESS
                          AND REACH THE TOP!
                        </h2>
                        <p>
                          Your web Design is as important as a soul is considered of the
                          body. Your web design enables you to create the theme that serves
                          tk be the foundation of your website. We are known for providing
                          the smart web solutions including the user-friendly and smart wen
                          design that grab the attention of your audience. You need to
                          present your brand as a well-reputed brand to the people Imagine
                          the dull and uninteresting websites running your brand image amog
                          your customers, or you are not able to create a strong impression
                          of your brand ;this could cost you alot. We can easily redesign
                          your existing website making it up to the caliber of your brand so
                          that you can easily retain your customers; climbing the top
                          position.
                        </p>
                      </div>
                  </div>
              </div>      
          </div>
        </section>
      
        <div className='testimonial-more'>
          <div className='testimonial-mores'>
            <blockquote> 
              <i className='fa fa-quote-left' aria-hidden='true' />
              Website development process is not a single step process; it needs
              proper planning and the highly skilled individuals having the
              proper knowledge about the latest technologies.
              <i className='fa fa-quote-right' aria-hidden='true' />
            </blockquote>
          </div>
        </div>
      </div>
    )
  };
}
export default Gallery;