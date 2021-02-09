// // ########## Import Dependencies Here ##########

import React from 'react';
import Blog from './Whatshappen/Blog';
import JuniorSchool from './JuniorSchool';
import Team from         './Team'; 



class Promo extends React.Component {

  componentDidMount(){

  }
  render() {
    return (
      <div className="home">
           <JuniorSchool />
           <Blog />
           <Team />
      </div>
    )
  };
}
export default Promo;