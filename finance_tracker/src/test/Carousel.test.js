import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import Carousel from '../components/Carousel';
import '@testing-library/jest-dom';

test('Carousel renders images correctly', () => {
  render(<Carousel />);
  
  expect(screen.getByAltText('Pie chart')).toHaveAttribute('src', 'Pie_chart.png');
});


