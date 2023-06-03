import React from 'react';
import axios from 'axios';
import ProductForm from './ProductForm';
import styled from 'styled-components';

const Container = styled.div`
  padding: 20px;
`;

const Title = styled.h1`
  font-size: 24px;
  margin-bottom: 20px;
`;

const ProductCreate = ({ navigate }) => {
  const productCreate = async (product) => {
    try {
      await axios.post('http://localhost:8080/products', product);
      navigate('/');
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <Container>
      <Title>Cadastrar Produto</Title>
      <ProductForm initialValues={{}} onSubmit={productCreate} />
    </Container>
  );
};

export default ProductCreate;
