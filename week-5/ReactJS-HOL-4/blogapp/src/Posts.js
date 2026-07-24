import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        // Map the JSON objects to Post class instances
        const mappedPosts = data.map(item => new Post(item.id, item.title, item.body));
        this.setState({ posts: mappedPosts });
      })
      .catch(err => {
        this.setState({ error: err.message });
        alert('Error loading posts: ' + err.message);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    // Alert the user about the error
    alert('An error occurred in Posts component: ' + error.toString());
    this.setState({ error: error.toString() });
  }

  render() {
    const { posts, error } = this.state;

    if (error) {
      return (
        <div className="error-container">
          <p className="error-message">Error: {error}</p>
        </div>
      );
    }

    return (
      <div className="blog-posts-list">
        {posts.map(post => (
          <article key={post.id} className="blog-post-card">
            <h4 className="blog-post-title">{post.title}</h4>
            <p className="blog-post-body">{post.body}</p>
          </article>
        ))}
      </div>
    );
  }
}

export default Posts;
