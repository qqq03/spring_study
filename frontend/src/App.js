import React, { useState } from 'react';

function CreatePost() {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [message, setMessage] = useState('');

  const submitPost = () => {
    fetch('http://localhost:8080/posts', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ title, content }),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error(`HTTP 오류: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        setMessage('게시글이 성공적으로 생성되었습니다!');
        setTitle('');
        setContent('');
      })
      .catch(error => {
        setMessage('게시글 생성 중 오류가 발생했습니다: ' + error.message);
      });
  };

  return (
    <div>
      <h2>게시글 작성</h2>
      <input
        type="text"
        placeholder="제목"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        style={{ display: 'block', marginBottom: '10px', width: '300px' }}
      />
      <textarea
        placeholder="내용"
        value={content}
        onChange={(e) => setContent(e.target.value)}
        rows="6"
        style={{ display: 'block', marginBottom: '10px', width: '300px' }}
      />
      <button onClick={submitPost}>게시글 작성</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default CreatePost;
