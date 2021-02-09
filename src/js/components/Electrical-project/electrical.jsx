// ########## Import Dependencies Here ##########
import React, { Component } from "react";

// import PropTypes from 'prop-types';

// ########## Import Screens Here ##########

// ########## Import Components Here ##########
// import ReadMoreButton from './ReadMoreButton';

export default class Electrical extends Component {
  constructor() {
    super();
    this.state = { value: "" };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleChange(e) {
    this.setState({ value: e.target.value });
  }
  handleSubmit(e) {
    alert(`Form is submitted:  ${this.state.value}`);
    e.preventDefault();
  }
  render() {
    return (
      <div className="Webdevelopment">
        <div className="electrical-caption">.</div>
        <div className="web-banner">
          <div>
            <h2>
              <strong>Electrical Project Developers</strong>
            </h2>
          </div>
          <div className="web-about">
            <p>
              <strong>Smart It Tec</strong> has proudly assisted in several
              projects based on MATLAB and Simulink. Our users include students,
              researchers and professionals including faculties and corporate
              employees. Since every project accomplished by ​our experts were
              for a unique user with their own purpose and use-case, we do not
              share the code or proprietary materials with anyone other than the
              user who had booked that service. What does it mean? Well, your
              work is secure with us forever. Any socurce code and related work
              completed by us for you will never be shared with any other user
              even in future. You can check a brief summary of some of the
              projects completed by us in past to get the understanding of level
              of the work done by our team of experts.
            </p>
          </div>
          <div className="hero-left">
            <h3>Signal processing on Matlab</h3>

            <div className="react">
              <p>
                Curabitur aliquam justo ex <strong>Smart It Tec </strong>
                ac varius sem facilisis a. In vel felis eros. Fusce ipsum enim,
                ultrices at ante sollicitudin, faucibus hendrerit nunc. Nullam
                tempor nulla eu imperdiet interdum.Curabitur aliquam justo ex,
                ac varius sem facilisis a. In vel felis eros. Fusce ipsum enim,
                ultrices at ante sollicitudin, faucibus hendrerit nunc. Nullam
                tempor nulla eu imperdiet interdum.Curabitur aliquam justo ex,
                ac varius sem facilisis a. In vel felis eros. Fusce ipsum enim,
                ultrices at ante sollicitudin, faucibus hendrerit nunc. Nullam
                tempor nulla eu imperdiet interdum.
              </p>
              <div
                className="web-img"
                data-aos="fade-left"
                data-aos-delay="200"
              >
                <img
                  src="/images/Electrical/Embeddedsystem.png"
                  className="img-fluid animated"
                  alt=""
                />
              </div>
            </div>
          </div>
          <div className="testimonial-more">
            <div className="testimonial-mores">
              <h4>
                <i className="fa fa-quote-left" aria-hidden="true" />
                Team of Professional Engineers online to develop your electrical
                engineering mini and final year projects and help you with best
                solution for your assignments.
                <i className="fa fa-quote-right" aria-hidden="true" />
              </h4>
            </div>
          </div>
          <div className="submit-assigment">
            <h2>SUBMIT YOUR PROJECT</h2>
            <p>
              You are on the best forum of electrical projects and assignment
              helpers. Get your projects developed and assignments done by the
              top engineers and coders in Arduino based projects, Embedded
              systems, Daily use electrical kits and gadgets, MATLAB based image
              processing, signal processing, Simulink and machine learning.
            </p>
            <div className="mailsender">
              <form>
                <div className="form-menu">
                  <input type="text" name="" autoComplete="off" required />
                  <label>Name</label>
                </div>
                <div className="form-menu">
                  <input type="email" name="" autoComplete="off" required />
                  <label>Email</label>
                </div>
                <div className="form-menu">
                  <input type="text" name="" autoComplete="off" required />
                  <label>Document Deadlines</label>
                </div>
                <div className="form-menu">
                  <input type="text" name="" autoComplete="off" required />
                  <label>Project/Assigment Title</label>
                </div>
                <div className="form-menu">
                  <input type="text" name="" autoComplete="off" required />
                  <label>Phone Number</label>
                </div>
                <div className="form-group">
                  <select className="form-control" id="country" name="country">
                    <option value="" selected="">
                      Select Country
                    </option>
                    <option value="Afghanistan"> Afghanistan</option>
                    <option value="Albania"> Albania</option>
                    <option value="Algeria"> Algeria</option>
                    <option value="American Samoa"> American Samoa</option>
                    <option value="Andorra"> Andorra</option>
                    <option value="Angola"> Angola</option>
                    <option value="Anguilla"> Anguilla</option>
                    <option value="Antarctica"> Antarctica</option>
                    <option value="Antigua and Barbuda">
                      Antigua and Barbuda
                    </option>
                    <option value="Argentina"> Argentina</option>
                    <option value="Armenia"> Armenia</option>
                    <option value="Aruba"> Aruba</option>
                    <option value="Australia"> Australia</option>
                    <option value="Austria"> Austria</option>
                    <option value="Azerbaijan"> Azerbaijan</option>
                    <option value="Bahamas"> Bahamas</option>
                    <option value="Bahrain"> Bahrain</option>
                    <option value="Bangladesh"> Bangladesh</option>
                    <option value="Barbados"> Barbados</option>
                    <option value="Belarus"> Belarus</option>
                    <option value="Belgium"> Belgium</option>
                    <option value="Belize"> Belize</option>
                    <option value="Benin"> Benin</option>
                    <option value="Bermuda"> Bermuda</option>
                    <option value="Bhutan"> Bhutan</option>
                    <option value="Bolivia"> Bolivia</option>
                    <option value="Bosnia and Herzegowina">
                      Bosnia and Herzegowina
                    </option>
                    <option value="Botswana"> Botswana</option>
                    <option value="Bouvet Island"> Bouvet Island</option>
                    <option value="Brazil"> Brazil</option>
                    <option value="British Indian Ocean Territory">
                      British Indian Ocean Territory
                    </option>
                    <option value="Brunei Darussalam">Brunei Darussalam</option>
                    <option value="Bulgaria"> Bulgaria</option>
                    <option value="Burkina Faso"> Burkina Faso</option>
                    <option value="Burundi"> Burundi</option>
                    <option value="Cambodia"> Cambodia</option>
                    <option value="Cameroon"> Cameroon</option>
                    <option value="Canada"> Canada</option>
                    <option value="Cape Verde"> Cape Verde</option>
                    <option value="Cayman Islands"> Cayman Islands</option>
                    <option value="Central African Republic">
                      Central African Republic
                    </option>
                    <option value="Chad"> Chad</option>
                    <option value="Chile"> Chile</option>
                    <option value="China"> China</option>
                    <option value="Christmas Island"> Christmas Island</option>
                    <option value="Cocos (Keeling) Islands">
                      Cocos (Keeling) Islands
                    </option>
                    <option value="Colombia"> Colombia</option>
                    <option value="Comoros"> Comoros</option>
                    <option value="Congo"> Congo</option>
                    <option value="Congo, the Democratic Republic of the">
                      Congo, the Democratic Republic of the
                    </option>
                    <option value="Cook Islands"> Cook Islands</option>
                    <option value="Costa Rica"> Costa Rica</option>
                    <option value="Croatia (Hrvatska)">
                      Croatia (Hrvatska)
                    </option>
                    <option value="Cuba"> Cuba</option>
                    <option value="Cyprus"> Cyprus</option>
                    <option value="Czech Republic"> Czech Republic</option>
                    <option value="Denmark"> Denmark</option>
                    <option value="Djibouti"> Djibouti</option>
                    <option value="Dominica"> Dominica</option>
                    <option value="Dominican Republic">
                      Dominican Republic
                    </option>
                    <option value="East Timor"> East Timor</option>
                    <option value="Ecuador"> Ecuador</option>
                    <option value="Egypt"> Egypt</option>
                    <option value="El Salvador"> El Salvador</option>
                    <option value="Equatorial Guinea">Equatorial Guinea</option>
                    <option value="Eritrea"> Eritrea</option>
                    <option value="Estonia"> Estonia</option>
                    <option value="Ethiopia"> Ethiopia</option>
                    <option value="Falkland Islands (Malvinas)">
                      Falkland Islands (Malvinas)
                    </option>
                    <option value="Faroe Islands"> Faroe Islands</option>
                    <option value="Fiji"> Fiji</option>
                    <option value="Finland"> Finland</option>
                    <option value="France"> France</option>
                    <option value="France Metropolitan">
                      France Metropolitan
                    </option>
                    <option value="French Guiana"> French Guiana</option>
                    <option value="French Polynesia"> French Polynesia</option>
                    <option value="French Southern Territories">
                      French Southern Territories
                    </option>
                    <option value="Gabon"> Gabon</option>
                    <option value="Gambia"> Gambia</option>
                    <option value="Georgia"> Georgia</option>
                    <option value="Germany"> Germany</option>
                    <option value="Ghana"> Ghana</option>
                    <option value="Gibraltar"> Gibraltar</option>
                    <option value="Greece"> Greece</option>
                    <option value="Greenland"> Greenland</option>
                    <option value="Grenada"> Grenada</option>
                    <option value="Guadeloupe"> Guadeloupe</option>
                    <option value="Guam"> Guam</option>
                    <option value="Guatemala"> Guatemala</option>
                    <option value="Guinea"> Guinea</option>
                    <option value="Guinea-Bissau"> Guinea-Bissau</option>
                    <option value="Guyana"> Guyana</option>
                    <option value="Haiti"> Haiti</option>
                    <option value="Heard and Mc Donald Islands">
                      Heard and Mc Donald Islands
                    </option>
                    <option value="Holy See (Vatican City State)">
                      Holy See (Vatican City State)
                    </option>
                    <option value="Honduras"> Honduras</option>
                    <option value="Hong Kong"> Hong Kong</option>
                    <option value="Hungary"> Hungary</option>
                    <option value="Iceland"> Iceland</option>
                    <option value="India"> India</option>
                    <option value="Indonesia"> Indonesia</option>
                    <option value="Iran (Islamic Republic of)">
                      Iran (Islamic Republic of)
                    </option>
                    <option value="Iraq"> Iraq</option>
                    <option value="Ireland"> Ireland</option>
                    <option value="Israel"> Israel</option>
                    <option value="Italy"> Italy</option>
                    <option value="Jamaica"> Jamaica</option>
                    <option value="Japan"> Japan</option>
                    <option value="Jordan"> Jordan</option>
                    <option value="Kazakhstan"> Kazakhstan</option>
                    <option value="Kenya"> Kenya</option>
                    <option value="Kiribati"> Kiribati</option>
                    <option value="Korea"> Korea</option>
                    <option value="Kuwait"> Kuwait</option>
                    <option value="Kyrgyzstan"> Kyrgyzstan</option>
                    <option value="Lao"> Lao</option>
                    <option value="Latvia"> Latvia</option>
                    <option value="Lebanon"> Lebanon</option>
                    <option value="Lesotho"> Lesotho</option>
                    <option value="Liberia"> Liberia</option>
                    <option value="Libyan Arab Jamahiriya">
                      Libyan Arab Jamahiriya
                    </option>
                    <option value="Liechtenstein"> Liechtenstein</option>
                    <option value="Lithuania"> Lithuania</option>
                    <option value="Luxembourg"> Luxembourg</option>
                    <option value="Macau"> Macau</option>
                    <option value="Macedonia, The Former Yugoslav Republic of">
                      Macedonia, The Former Yugoslav Republic of
                    </option>
                    <option value="Madagascar"> Madagascar</option>
                    <option value="Malawi"> Malawi</option>
                    <option value="Malaysia"> Malaysia</option>
                    <option value="Maldives"> Maldives</option>
                    <option value="Mali"> Mali</option>
                    <option value="Malta"> Malta</option>
                    <option value="Marshall Islands"> Marshall Islands</option>
                    <option value="Martinique"> Martinique</option>
                    <option value="Mauritania"> Mauritania</option>
                    <option value="Mauritius"> Mauritius</option>
                    <option value="Mayotte"> Mayotte</option>
                    <option value="Mexico"> Mexico</option>
                    <option value="Micronesia, Federated States of">
                      Micronesia, Federated States of
                    </option>
                    <option value="Moldova, Republic of">
                      Moldova, Republic of
                    </option>
                    <option value="Monaco"> Monaco</option>
                    <option value="Mongolia"> Mongolia</option>
                    <option value="Montserrat"> Montserrat</option>
                    <option value="Morocco"> Morocco</option>
                    <option value="Mozambique"> Mozambique</option>
                    <option value="Myanmar"> Myanmar</option>
                    <option value="Namibia"> Namibia</option>
                    <option value="Nauru"> Nauru</option>
                    <option value="Nepal"> Nepal</option>
                    <option value="Netherlands"> Netherlands</option>
                    <option value="Netherlands Antilles">
                      Netherlands Antilles
                    </option>
                    <option value="New Caledonia"> New Caledonia</option>
                    <option value="New Zealand"> New Zealand</option>
                    <option value="Nicaragua"> Nicaragua</option>
                    <option value="Niger"> Niger</option>
                    <option value="Nigeria"> Nigeria</option>
                    <option value="Niue"> Niue</option>
                    <option value="Norfolk Island"> Norfolk Island</option>
                    <option value="Northern Mariana Islands">
                      Northern Mariana Islands
                    </option>
                    <option value="Norway"> Norway</option>
                    <option value="Oman"> Oman</option>
                    <option value="Pakistan"> Pakistan</option>
                    <option value="Palau"> Palau</option>
                    <option value="Panama"> Panama</option>
                    <option value="Papua New Guinea"> Papua New Guinea</option>
                    <option value="Paraguay"> Paraguay</option>
                    <option value="Peru"> Peru</option>
                    <option value="Philippines"> Philippines</option>
                    <option value="Pitcairn"> Pitcairn</option>
                    <option value="Poland"> Poland</option>
                    <option value="Portugal"> Portugal</option>
                    <option value="Puerto Rico"> Puerto Rico</option>
                    <option value="Qatar"> Qatar</option>
                    <option value="Reunion"> Reunion</option>
                    <option value="Romania"> Romania</option>
                    <option value="Russian Federation">
                      Russian Federation
                    </option>
                    <option value="Rwanda"> Rwanda</option>
                    <option value="Saint Kitts and Nevis">
                      Saint Kitts and Nevis
                    </option>
                    <option value="Saint Lucia"> Saint Lucia</option>
                    <option value="Saint Vincent and the Grenadines">
                      Saint Vincent and the Grenadines
                    </option>
                    <option value="Samoa"> Samoa</option>
                    <option value="San Marino"> San Marino</option>
                    <option value="Sao Tome and Principe">
                      Sao Tome and Principe
                    </option>
                    <option value="Saudi Arabia"> Saudi Arabia</option>
                    <option value="Senegal"> Senegal</option>
                    <option value="Seychelles"> Seychelles</option>
                    <option value="Sierra Leone"> Sierra Leone</option>
                    <option value="Singapore"> Singapore</option>
                    <option value="Slovakia (Slovak Republic)">
                      Slovakia (Slovak Republic)
                    </option>
                    <option value="Slovenia"> Slovenia</option>
                    <option value="Solomon Islands"> Solomon Islands</option>
                    <option value="Somalia"> Somalia</option>
                    <option value="South Africa"> South Africa</option>
                    <option value="South Georgia and the South Sandwich Islands">
                      South Georgia and the South Sandwich Islands
                    </option>
                    <option value="Spain"> Spain</option>
                    <option value="Sri Lanka"> Sri Lanka</option>
                    <option value="St. Helena"> St. Helena</option>
                    <option value="St. Pierre and Miquelon">
                      St. Pierre and Miquelon
                    </option>
                    <option value="Sudan"> Sudan</option>
                    <option value="Suriname"> Suriname</option>
                    <option value="Svalbard and Jan Mayen Islands">
                      Svalbard and Jan Mayen Islands
                    </option>
                    <option value="Swaziland"> Swaziland</option>
                    <option value="Sweden"> Sweden</option>
                    <option value="Switzerland"> Switzerland</option>
                    <option value="Syrian Arab Republic">
                      Syrian Arab Republic
                    </option>
                    <option value="Taiwan, Province of China">
                      Taiwan, Province of China
                    </option>
                    <option value="Tajikistan"> Tajikistan</option>
                    <option value="Tanzania, United Republic of">
                      Tanzania, United Republic of
                    </option>
                    <option value="Thailand"> Thailand</option>
                    <option value="Togo"> Togo</option>
                    <option value="Tokelau"> Tokelau</option>
                    <option value="Tonga"> Tonga</option>
                    <option value="Trinidad and Tobago">
                      Trinidad and Tobago
                    </option>
                    <option value="Tunisia"> Tunisia</option>
                    <option value="Turkey"> Turkey</option>
                    <option value="Turkmenistan"> Turkmenistan</option>
                    <option value="Turks and Caicos Islands">
                      Turks and Caicos Islands
                    </option>
                    <option value="Tuvalu"> Tuvalu</option>
                    <option value="Uganda"> Uganda</option>
                    <option value="Ukraine"> Ukraine</option>
                    <option value="United Arab Emirates">
                      United Arab Emirates
                    </option>
                    <option value="United Kingdom"> United Kingdom</option>
                    <option value="United States"> United States</option>
                    <option value="United States Minor Outlying Islands">
                      United States Minor Outlying Islands
                    </option>
                    <option value="Uruguay"> Uruguay</option>
                    <option value="Uzbekistan"> Uzbekistan</option>
                    <option value="Vanuatu"> Vanuatu</option>
                    <option value="Venezuela"> Venezuela</option>
                    <option value="Vietnam"> Vietnam</option>
                    <option value="Virgin Islands (British)">
                      Virgin Islands (British)
                    </option>
                    <option value="Virgin Islands (U.S.)">
                      Virgin Islands (U.S.)
                    </option>
                    <option value="Wallis and Futuna Islands">
                      Wallis and Futuna Islands
                    </option>
                    <option value="Western Sahara"> Western Sahara</option>
                    <option value="Yemen"> Yemen</option>
                    <option value="Yugoslavia"> Yugoslavia</option>
                    <option value="Zambia"> Zambia</option>
                    <option value="Zimbabwe"> Zimbabwe</option>
                  </select>
                </div>
                <div className="form-file">
                  <input
                    accept=".pdf"
                    className="cf-multi-uploader"
                    data-controlid="trupl5fd875da6785e"
                    type="file"
                    data-field="fld_1720034"
                    id="fld_1720034_1"
                    name="fld_1720034"
                  />
                  <br />
                </div>
                <div className="form-menu">
                  <textarea required="">.</textarea>
                  <label>Message</label>
                </div>
                <input type="submit" name="" value="Submit" />
              </form>
            </div>
          </div>
          <div className="we-do">
            <div className="what-we-do">
              <h2>LET’S START SOMETHING NEW</h2>
              <h3>Electrical Project Developers</h3>
              <h4>Services</h4>
              <ul className="plus">
                <li>Mini and Final Year Projects</li>
                <li>Arduino Based Projects</li>
                <li>Embedded Systems</li>
                <li>MATLAB Based Projects</li>
                <li>Internet of Things Projects</li>
              </ul>
            </div>
          </div>
          <div className="services">
            <div className="services-arduino">
              <h2>Arduino Based Projects</h2>
              <div
                className="service-images"
                data-aos="fade-left"
                data-aos-delay="200"
              >
                <img
                  src="/images/Electrical/Arduinoprojects.png"
                  className="img-fluid animated"
                  alt=""
                />
              </div>
              <div className="services-arduino-p">
                <p>
                  We are providing Arduino based Projects for engineering
                  students all over Pakistan. Our qualified and talented
                  engineers will develop mini and final year projects for you
                  while leaving you with peace of mind. We are providing Arduino
                  based Projects for engineering students all over Pakistan. Our
                  qualified and talented engineers will develop mini and final
                  year projects for you while leaving you with peace of mind.
                </p>
              </div>
            </div>
            <div className="services-embedded">
              <h2>Embedded Systems </h2>

              <div className="services-embedded-p">
                <p>
                  Embedded systems are widely used as microprocessor-based
                  computer hardware system with software that is designed to
                  perform a dedicated function. If you want embedded system as
                  final year project you are at the right place
                </p>
                <div
                  className="embedded-img"
                  data-aos="fade-left"
                  data-aos-delay="200"
                >
                  <img
                    src="/images/Electrical/Embeddedsystem2.png"
                    className="img-fluid animated"
                    alt=""
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="Services-part">
            <div className="services-matlab">
              <h2>MATLAB Based Projects</h2>
              <div
                className="service-images"
                data-aos="fade-left"
                data-aos-delay="200"
              >
                <img
                  src="/images/Electrical/matlab1.png"
                  className="img-fluid animated"
                  alt=""
                />
              </div>
              <div className="services-matlab-p">
                <p>
                  MATLAB is widely used for image processing, signal and
                  systems, machine learning and simulation based projects and
                  assignments. If you have trouble with some code and
                  simulation, this is the right place to ask for help.
                </p>
              </div>
            </div>
            <div className="services-iot">
              <h2>Internet of Things Projects</h2>
              <div
                className="service-images"
                data-aos="fade-left"
                data-aos-delay="200"
              >
                <img
                  src="/images/Electrical/IOT.png"
                  className="img-fluid animated"
                  alt=""
                />
              </div>
              <div className="services-iot-p">
                <p>
                  IOT is widely used for Automated and Smart technology based
                  systems and final year projects. Our engineers develop IoT
                  based projects at professional level and with best prices.
                </p>
              </div>
            </div>
          </div>
          <div className="wpb_wapper">
            <div className="max-title">
              <h2>Why we are different</h2>
            </div>
            <div className="wpb_text_column wpb_content_element">
              <p>
                Professional Knowledge Our Outstanding Features Make Us The
                First Choice For Electrical Projects Service.
              </p>
              <p>
                Guaranteed First Class Project / Assignment Programmed by –
                professionals, experts and industry practitioners.
              </p>
            </div>
            <div className="vc_row wpb_row">
              <ul className="plus">
                <li>Well-developed, maintainable and efficient projects.</li>
                <li>Project/Assignment delivery before even deadlines.</li>
                <li>
                  Best quality and originality in projects programming code and
                  simulation.
                </li>
                <li>Experienced & Qualified Experts.</li>
                <li>Affordable Pricing and Flexible Payment Method.</li>
                <li>24*7 Customer Service and Friendly Staff.</li>
                <li>Direct Conversation with the Expert over Chat and Call.</li>
                <li>100% Confidentiality, affordable pricing, 24×7 support.</li>
                <li>
                  Rich experience in helping students with electrical projetcs.
                </li>
              </ul>
            </div>
            <div className="vc_column">
              <img
                src="../images/Logo-design/Darcha-tea-house-animated-logo-design-branding-Arabic-Chinese-interabang.gif"
                alt=""
              />
            </div>
          </div>
          <section className="ecommerce-portfolio">
            <div className="container-fluid">
              <div className="row">
                <div className="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                  <div className="text-center center-block">
                    <span className="h3-title">
                      Our
                      <span> Latest Work</span>
                    </span>
                    <p>
                      Density based traffic signal controller using image
                      processing along with emergency vehicle siren detection
                      using neural networks.
                    </p>
                  </div>
                  <div className="clearfix"></div>
                </div>

                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork1.jpg"
                      className="img-responsive"
                      alt="electro Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork2.jpg"
                      className="img-responsive"
                      alt="fazihoner Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork3.jpg"
                      className="img-responsive"
                      alt="jewelry Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork4.jpg"
                      className="img-responsive"
                      alt="Moda Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork5.jpg"
                      className="img-responsive"
                      alt="Shoes Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork6.jpg"
                      className="img-responsive"
                      alt="Yozi Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork7.jpg"
                      className="img-responsive"
                      alt="Yozi Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork8.jpg"
                      className="img-responsive"
                      alt="Yozi Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork9.jpg"
                      className="img-responsive"
                      alt="Yozi Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork10.jpg"
                      className="img-responsive"
                      alt="Yozi Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork11.jpg"
                      className="img-responsive"
                      alt="Yozi Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="../images/Electrical/lastestwork12.jpg"
                      className="img-responsive"
                      alt="Yozi Electrical Store"
                    />
                  </div>
                </div>
                <div className="col-xs-12 col-sm-6 col-md-4 col-lg-4">
                  <div className="portfolio-box">
                    <img
                      src="/images/Electrical/lastestwork13.jpg"
                      className="img-responsive"
                      alt="Yozi Electrical Store"
                    />
                  </div>
                </div>
              </div>
            </div>
          </section>
          <div className="our-skills">
              <h2>our skills</h2>
              <p>
                We have curated a lots of information and knowledge with help of
                our certified electrical engineers and Matlab experts for
                students seeking developed mini and final year projects and
                Matlab programming.
              </p>
            <div className="skills">
              <div className="skills-label">
                <h4>html</h4>
                <span className="precent">87%</span>
              </div>
            </div>
          </div>
          <div className="ahmad">
            <div className="col-md-10 col-md-offset-1">
              <div className="wow fadeInUp text-center h-center ">
                <h3>
                  FOR STUDENTS <strong>, BY EXPERTS</strong>
                </h3>
                <div className="process-title">
                  <small>
                    Smart IT Tech has some of the best electrical engineers and
                    MATLAB experts for developing electrical projects and daily
                    use kits and providing help with MATLAB homework and MATLAB
                    project help in the areas of computational mathematics
                    (numerical computing), development of algorithms, image
                    processing, modeling and simulation of systems. Experts here
                    have Bachelors degree in domains of electrical engineering
                    and professional experience in fields of image processing,
                    signal processing, control system, parallel computing,
                    neural networks, embedded systems and Mathematics.
                  </small>
                </div>
                <div className="our-process-wrap">
                  <div className="our-process-item">
                    <i className="fas fa-magic" />
                    <h4>Project Development</h4>
                    <p>
                      Our Engineers will complete your Electrical mini and final
                      year Project without compromising on the quality in the
                      given time.
                    </p>
                  </div>
                  <div className="our-process-item">
                    <i className="fas fa-filter" />
                    <h4>Assignment Help</h4>
                    <p>
                      We have professional engineers online so that you can get
                      optimistic results by availing our Electrical and MATLAB
                      assignment help service.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <section className="container">
            <div className="row-wrapper-x">.</div>
          </section>
          <section className="blox w-animate  w-start_animation">
            <div className="container">
              <div className="vc_column-inner">
                <div className="wpb_wrapper">
                  <div className="wpb_text_column wpb_content_element ">
                    <div className="wpb_wrapper">
                      <p className="devpg_new">
                        Affordable Web Application Development
                      </p>
                      <p className="devpg_neww">
                        &amp; Web Development Services
                      </p>
                    </div>
                  </div>
                  <div className="wpb_text_column wpb_content_element  vc_custom_1598870172637">
                    <div className="wpb_wrapper">
                      <p>
                        Smart It Tec has been developing and designing websites
                        for over 14 years. We understand how important it is for
                        your website to be developed according to your company’s
                        requirements that is why we offer a wide range of
                        custom, but affordable Web Application Development &amp;
                        Web Development Services to ensure Smart It Tec deliver
                        a product &amp; services that suits you. Smart It Tec
                        Web Application Development &amp; Web Development
                        Services are affordable, professional and top quality.
                        At Smart It Tec our Web Application Development &amp;
                        Web Development Services team work closely with you to
                        understand your business needs, and believe in our
                        clients having a top level of control over the developed
                        product. Whatever you’re searching for, whether a
                        tailor-made Web Development Services, or Web Application
                        Development, our experienced team will be happy to help.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <section className="divider">
            <div className="container wow fadeInUp animated">
              <div className="row">
                <div className="col-md-8 col-md-offset-2">
                  <div className="divider-para">
                    <p>
                      <i className="fa fa-quote-left" /> An impressive design
                      alone is not enough; you need to provide a great
                      experience to the user by offering the user-friendly
                      design. <i className="fa fa-quote-right" />
                    </p>
                  </div>
                  <div className="divider-img">
                    <img
                      src="/images/web-development/web_development_03_1.png"
                      alt=""
                    />
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
      </div>
    );
  }
}

Electrical.propTypes = {};
