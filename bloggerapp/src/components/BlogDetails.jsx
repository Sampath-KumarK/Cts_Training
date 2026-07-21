function BlogDetails() {

  const blogs = [
    {
      id: 1,
      title: "Learning React",
      author: "Sampath"
    },
    {
      id: 2,
      title: "JavaScript ES6",
      author: "John"
    },
    {
      id: 3,
      title: "Spring Boot Guide",
      author: "David"
    }
  ];

  return (
    <div>

      <h2>Blog Details</h2>

      <ul>

        {blogs.map(blog => (

          <li key={blog.id}>
            <b>{blog.title}</b> - {blog.author}
          </li>

        ))}

      </ul>

    </div>
  );
}

export default BlogDetails;