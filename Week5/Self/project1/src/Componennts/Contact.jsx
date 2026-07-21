import React from 'react'
import { Link } from 'react-router-dom'

function Contact() {
  return (
    <div>
      <h1>Contact Us</h1>
      <p>This is the Contact page.</p>
            <Link to="/about">About</Link>
      <Link to="/contact">Contact</Link>
      <Link to="/">Home</Link>
    </div>
  )
}

export default Contact
