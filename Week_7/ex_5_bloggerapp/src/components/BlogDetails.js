import React from 'react';

const blogs = [
  {
    title: 'React Learning',
    author: 'Stephen Biz',
    description: 'Welcome to learning React!'
  },
  {
    title: 'Installation',
    author: 'Schewzdenier',
    description: 'You can install React from npm.'
  }
];

function BlogDetails() {
  return (
    <div className="section">
      <h2>Blog Details</h2>
      {blogs.map((blog, index) => (
        <div key={index}>
          <strong>{blog.title}</strong>
          <p><em>{blog.author}</em></p>
          <p>{blog.description}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
