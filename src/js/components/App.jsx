import React, { Component } from 'react';
import { connect } from 'react-redux';
// import PropTypes from 'prop-types';
import {
  BrowserRouter as Router,
  // Link,
  Route,
  Switch,
  withRouter
} from 'react-router-dom';
// import Topbar from './topbar/topbar';
import Header from './header';
// import HeroImage from './hero/HeroImage';
// import Promo from './promo/Promo';
// import Calender from './calender/Calender';
// import Blog from './Whatshappen/Blog';
// import Gallery from './gallery/Gallery';
import Footer from './footer/Footer';
import Career from './career/Career';
import Home from './Home/Home';
import MobileApp from './MobileApp/MobileApp';
import Seo from './Seo/seo';
import PhotoGallery from './photogallery/PhotoGallery';
import Logo from './Logo/logo';
import Achievers from './achievers/Achievers';
import Events from './events/Events';
import Contact from './contact/Contact';
import Ecommerce from './E-commerce/Ecommerce';
import Policies from './policies/Policies';
import Webdevelopment from './Webdevelopment/webdevelopment';
import Electrical from './Electrical-project/electrical';
import Blogsingle from './Blog/blogsingle';
import Blog from './Blog/blog';
import SignIn from './signin/SignIn';
import HR from './hr/HR';
import Dashboard from './dashboard/Dashboard';

class App extends Component {
  // constructor() {
  //   super();
  // }

  componentDidMount() {}

  render() {
    // let { } = this.props;
    return (
      
        <div className="app">
          {this.props.location.pathname === '/blog' ? '' :<Header />}
          <Switch>
            <Route exact path="/career" component={Career} />
            <Route exact path="/dashboard" component={Dashboard} />
            <Route exact path="/sign-in" component={SignIn} />
            <Route exact path="/mobile-app-development" component={MobileApp} />
            <Route exact path='/electrical-project-development' component={Electrical} />
            <Route exact path="/search-engine-optimization" component={Seo} />
            <Route exact path="/photo-galleries" component={PhotoGallery} />
            <Route exact path="/logo" component={Logo} />
            <Route exact path="/annual-achievers" component={Achievers} />
            <Route exact path="/events" component={Events} />
            <Route exact path="/blog"   component={Blog} />
            <Route exact path="/blogsingle" component={Blogsingle} />
            <Route exact path="/contact" component={Contact} />
            <Route exact path="/policies" component={Policies} />
            <Route exact path="/web-development-services" component={Webdevelopment} />
            <Route exact path="/ecommerce-website-development" component={Ecommerce} />
            <Route exact path="/hr" component={HR} />
            <Route path="/" component={Home} />
          </Switch>
          {this.props.location.pathname === '/blog' ? '' :<Footer />}
        </div>
    );
  }
}

// App.propTypes = {
//   //getAction: PropTypes.func.isRequired,
// };

function mapStateToProps(state) {
  return {
    test: state.test
  };
}

export default connect(mapStateToProps, {})(withRouter(App));
