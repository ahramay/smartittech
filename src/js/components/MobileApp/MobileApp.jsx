import React, { Component } from 'react';

import Hero from '../hero/HeroImage';

export default class MobileApp extends Component {
	componentDidMount() {}
	render() {
		return (
		  <div className="MobileApp">
		   <Hero style={'MobileApp-img'} />
			<div>
					COMPING SOON..
			</div>
		  </div>
		);
	}
}
