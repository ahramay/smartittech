import React, { Component } from 'react';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
// import Hero from '../hero/HeroImage';
import Silderimg from '../silderimg/silderimg';
// import Calender from '../calender/Calender';
import Gallery from '../gallery/Gallery';
import Promo from '../promo/Promo';
import * as actions from '../../actions';

class Home extends Component {
  constructor(props) {
    super(props);
    const { getPromoAction } = this.props;
    getPromoAction();
  }

  componentDidMount() {}
  render() {
    // const { style } = this.props;

    return (
      <div className="Home">
        <Silderimg />  
        <Gallery />
        <Promo />
        
      </div>
    );
  }
}

Home.propTypes = {
  // style: PropTypes.isRequired,
  getPromoAction: PropTypes.func.isRequired
};

// function mapStateToProps(state) {
//   return {
//     test: state.test
//   };
// };

export default connect(null, { getPromoAction: actions.getPromoAction })(Home);
