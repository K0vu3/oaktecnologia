import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ProductForm from './ProductForm';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';

const Container = styled.div`
  padding: 20px;
`;

const Title = styled.h1`
  font-size: 24px;
  margin-bottom: 20px;
`;

const Loading = styled.p`
  font-size: 18px;
`;

const ProductEdit = ({ match, history }) => {
  const [product, setProduct] = useState(null);
  const { id } = useParams();

  useEffect(() => {
    fetchProduct();
  }, []);

  const fetchProduct = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/products/${id}`);
      setProduct(response.data.content);
    } catch (error) {
      console.error(error);
    }
  };

  const updateProduct = async (updatedProduct) => {
    try {
      await axios.put(`http://localhost:8080/products/${match.params.id}`, updatedProduct);
      history.push('/');
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <Container>
      <Title>Editar Produto</Title>
      {product ? (
        <ProductForm initialValues={product} onSubmit={updateProduct} />
      ) : (
        <Loading>Carregando...</Loading>
      )}
    </Container>
  );
};

export default ProductEdit;
