import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const Container = styled.div`
  padding: 20px;
`;

const Title = styled.h2`
  font-size: 24px;
  margin-bottom: 20px;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
`;

const Label = styled.label`
  margin-bottom: 10px;
`;

const Input = styled.input`
  padding: 5px;
  margin-bottom: 10px;
`;

const Button = styled.button`
  padding: 5px 10px;
  background-color: #4caf50;
  color: white;
  border: none;
  cursor: pointer;
  &:hover {
    background-color: #45a049;
  }
`;

const ProductForm = ({ initialValues, onSubmit }) => {
  const [name, setName] = useState(initialValues.name || '');
  const [description, setDescription] = useState(initialValues.description || '');
  const [price, setPrice] = useState(initialValues.price || '');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const product = { name, description, price };

    try {
      await axios.post('http://localhost:8080/products', product);
      navigate('/');
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <Container>
      <Title>Cadastrar</Title>
      <Form onSubmit={handleSubmit}>
        <Label>Nome</Label>
        <Input
          type='text'
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <Label>Descrição</Label>
        <Input
          type='text'
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        <Label>Preço</Label>
        <Input
          type='text'
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />
        <Button type='submit'>Salvar</Button>
      </Form>
    </Container>
  );
};

export default ProductForm;
