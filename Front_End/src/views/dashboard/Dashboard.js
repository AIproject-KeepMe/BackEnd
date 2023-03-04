import React from 'react';
import { Grid, Box } from '@mui/material';
import PageContainer from 'src/components/container/PageContainer';
// components
import AlertPeople from './components/AlertPeople';
import Map from './components/Map';
import StateList from './components/StateList';
import { useCookies } from 'react-cookie';
import { Navigate } from 'react-router-dom';


const Dashboard = () => {
  const [cookies] = useCookies(['adminId']);
  console.log(cookies)

  if (!cookies.adminId) {
    alert('로그인하세요.');
    return <Navigate to="/auth/login" replace />;
  }

  return (
    <PageContainer title="KeepMe - 스마트솔루션" description="this is Dashboard">
      <Box>
        <Grid container spacing={2} >
          <Grid item xs={12} >
            <AlertPeople />
          </Grid>
          <Grid item xs={12} lg={6}>
            <StateList />
          </Grid>
          <Grid item xs={12} lg={6}>
            <Map />
          </Grid>
        </Grid>
      </Box>
    </PageContainer >
  );
};

export default Dashboard;
