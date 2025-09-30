// components/HeroCircle.jsx
import React from "react";
import "./HeroCircle.css"; // CSS ayrı olacak

export default function HeroCircle() {
  return (
    <div className="hero-circle-wrapper">
      {/* Hero SVG daire ve metinler */}
      <svg
        className="hero-svg"
        width="200"
        height="200"
        viewBox="0 0 200 200"
      >
        <circle
          cx="100"
          cy="100"
          r="60"
          fill="none"
          stroke="#e8b681"
          strokeWidth="2"
        />
        <text fontSize="16" fill="#ffffffff">
          <textPath href="#circlePath" startOffset="0">
            Advanced Engineering Solutions
          </textPath>
        </text>
        <text fontSize="16" fill="#ffffffff">
          <textPath href="#circlePath" startOffset="50%">
            Professional Engineering Services
          </textPath>
        </text>
        <defs>
          <path
            id="circlePath"
            d="M 100,100 m -90,0 a 90,90 0 1,1 180,0 a 90,90 0 1,1 -180,0"
          />
        </defs>
      </svg>

      {/* Logo */}
      <div className="logo-placeholder">
        <img
          src="/imagesBannerLogo/LOGOSnew2.png"
          alt="Logo"
          className="logo-image"
        />
      </div>
    </div>
  );
}
