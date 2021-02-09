// ########## Import Dependencies Here ##########
import React, { Component } from 'react';

// ########## Import Screens Here ##########

// ########## Import Components Here ##########

export default class WinsomeSchool extends Component {
  
  componentDidMount() {

  }
  render() {
    return (
      <section className="services">
          <div className="container">
            <div className="section-header">
              <h3>Services</h3>
                <p>Sed tamen tempor magna labore dolore dolor sint tempor duis magna elit veniam aliqua esse amet veniam enim export quid quid veniam aliqua eram noster malis nulla duis fugiat culpa esse aute nulla ipsum velit export irure minim illum fore</p>
            </div>
            <div className="row">
              <div className="col-lg-6">
                <div className="box">
                  <img className="icon-1" src="../images/Home/icon-1.png" alt="web" />
                    <h4 className="title-1"><a href="services">Web development</a></h4>
                      <p className="description">Minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat tarad limino ata nodera clas.</p>
                </div>
              </div>
              <div className="col-lg-6">
                <div className="box">
                  <img className="icon" src="../images/Home/icon-2.png" alt="web" />
                    <h4 className="title"><a href="services">SEO</a></h4>
                      <p className="description">Voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident etiro rabeta lingo.</p>
                </div>
              </div>
              <div className="col-lg-6">
                <div className="box" data-wow-delay="0.2s">
                  <img className="icon-2" src="../images/Home/icon-3.png" alt="web" />
                    <h4 className="title"><a href="services">Graphic designing</a></h4>
                      <p className="description">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur trinige zareta lobur trade.</p>
                </div>
              </div>
              <div className="col-lg-6">
                <div className="box" data-wow-delay="0.2s">
                  <img className="icon" src="../images/Home/icon-4.png" alt="web" />
                    <h4 className="title"><a href="services">Web designing</a></h4>
                      <p className="description">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim className est laborum rideta zanox satirente madera</p>
                </div>
              </div>
              <div className="col-lg-6">
                <div className="box" data-wow-delay="0.2s">
                  <img className="icon" src="../images/Home/icon-5.png" alt="" />
                    <h4 className="title"><a href="services">C++</a></h4>
                      <p className="description">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim className est laborum rideta zanox satirente madera</p>
                </div>
              </div>
              <div className="col-lg-6">
                <div className="box" data-wow-delay="0.2s">
                  <img className="icon-3" src="../images/Home/icon-6.png" alt="" />
                    <h4 className="title"><a href="services">Social Media</a></h4>
                      <p className="description">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim className est laborum rideta zanox satirente madera</p>
                </div>
              </div>
            </div>
          </div>
      </section>
    );
  };
}

WinsomeSchool.propTypes = {
}