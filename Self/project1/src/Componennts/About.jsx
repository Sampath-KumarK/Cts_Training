import React from 'react'

function About() {
  return (
    <div>
      <h1>About Us</h1>
      <p>This is the About page.</p>
            <Link to="/about">About</Link>
      <Link to="/contact">Contact</Link>
      <Link to="/">Home</Link>
    </div>
  )
}

export default About
