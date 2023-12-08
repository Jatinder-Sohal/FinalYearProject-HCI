import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import Carousel from '../components/Carousel';
import '@testing-library/jest-dom';

/**
 * @test TestCarouselLoads
 * Testing if carousel images load and default is pie chart
 */
test('Carousel images loading', () => {
    render(<Carousel />);
  
    expect(screen.getByAltText('Pie chart')).toHaveAttribute('src', 'Pie_chart.png');
});

/**
 * @test Test1
 * Testing if control buttons switch images
 */
test('Carousel controls work', () => {
    render(<Carousel />);
    
    fireEvent.click(screen.getByRole('button', { name: 'Next' }));
    expect(screen.getByAltText('Bar graph')).toHaveAttribute('src', 'Bar_graph.png');

});

/**
 * @test
 * Testing if carousel indicators change on slide change
 */
test('Carousel indicators', () => {
    render(<Carousel />);
    
    fireEvent.click(screen.getByRole('button', { name: 'Next' }));
    expect(screen.getByRole('button', { name: 'Slide 2' })).toHaveClass('active');

});

