import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {

    constructor(props) {
        super(props);

        this.state = {
            posts: [],
            error: null
        };
    }

    // Fetch Posts
    loadPosts = () => {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Unable to fetch posts");
                }
                return response.json();
            })
            .then((data) => {

                const posts = data.map(
                    (item) =>
                        new Post(item.id, item.title, item.body)
                );

                this.setState({
                    posts: posts
                });
            })
            .catch((error) => {
                this.setState({
                    error: error
                });
            });
    };

    // Lifecycle Hook
    componentDidMount() {
        this.loadPosts();
    }

    // Error Handling Hook
    componentDidCatch(error, info) {
        alert("Error: " + error.message);
        console.log(error);
        console.log(info);
    }

    render() {

        if (this.state.error) {
            return <h2>{this.state.error.message}</h2>;
        }

        return (
            <div style={{ padding: "20px" }}>
                <h1>Posts</h1>

                {this.state.posts.map((post) => (
                    <div
                        key={post.id}
                        style={{
                            border: "1px solid gray",
                            padding: "15px",
                            marginBottom: "15px",
                            borderRadius: "8px"
                        }}
                    >
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;