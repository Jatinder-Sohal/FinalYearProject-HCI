import React from "react";
import Navbar from "../components/Navbar";
import Carousel from "../components/Carousel";
import './DisplayData.css';

function DisplayData() {
  return (
    <div className="page4-container">
        <Navbar />
        <h1 className="title">Some Recommendations on How to Cut Costs</h1>
        <div className="custom-container">
        <Carousel />
        </div>

        <div className="content">
        <section className="section">
          <h2 className="section-title">Cutting Bills</h2>
          <p>Here are some tips on how to reduce your bills:</p>
          <ul className="recommendation-list">
            <li>Switch to energy-efficient appliances or natural energy sources.</li>
            <li>Use smart thermostats to regulate heating and cooling.</li>
            <li>Shop for better insurance rates e.g using moneysupermarket.</li>
          </ul>
        </section>

  <section className="section">
    <h2 className="section-title">Cutting Food Expenses</h2>
    <p>Consider these strategies to save on food expenses:</p>
    <ul className="recommendation-list">
      <li>Create a list of groceries and stick to budget.</li>
      <li>Plan meals in advance to avoid eating out frequently.</li>
      <li>Look for discounts and coupons when shopping.</li>
    </ul>
  </section>

  <section className="section">
    <h2 className="section-title">Other Sources of Income</h2>
    <p>Explore additional income options:</p>
    <ul className="recommendation-list">
      <li>Take on a part-time job or freelance work.</li>
      <li>Rent out a spare room or property on platforms like Airbnb.</li>
      <li>Invest in stocks or other income-generating assets.</li>
    </ul>
  </section>
        </div>
    </div>
  );
}

export default DisplayData;
