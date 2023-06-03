import React, { useEffect, useState } from "react";
import axios from 'axios';
import { Link } from "react-router-dom";
import styled from "styled-components";

const Container = styled.div`
  padding: 20px;
`;

const Title = styled.h1`
  font-size: 24px;
  margin-bottom: 20px;
`;

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`;

const Th = styled.th`
  padding: 10px;
  background-color: #f2f2f2;
  font-weight: bold;
`;

const Td = styled.td`
  padding: 10px;
  border-bottom: 1px solid #ddd;
`;

const Button = styled.button`
  padding: 5px 10px;
  background-color: #f44336;
  color: white;
  border: none;
  cursor: pointer;
  &:hover {
    background-color: #d32f2f;
  }
`;


const ProductList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await axios.get('http://localhost:8080/products');
      setProducts(response.data.content);
    } catch (error) {
      console.error(error);
    }
  };

  const deleteProduct = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/products/${id}`);
      fetchProducts();
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <Container>
      <Title>Lista de Produtos</Title>
      <Table>
        <thead>
          <tr>
            <Th>Nome</Th>
            <Th>Descrição</Th>
            <Th>Preço</Th>
            <Th>Editar</Th>
            <Th>Deletar</Th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product.id}>
              <Td>{product.name}</Td>
              <Td>{product.description}</Td>
              <Td>{product.price}</Td>
              <Td>
                <Link to={`/edit/${product.id}`}>Editar</Link>
              </Td>
              <Td>
                <Button onClick={() => deleteProduct(product.id)}>Deletar</Button>
              </Td>
            </tr>
          ))}
        </tbody>
      </Table>
      <Link to="/create">Cadastrar Produto</Link>
    </Container>
  );
}

export default ProductList;
