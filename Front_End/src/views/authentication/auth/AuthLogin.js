import React, { useState } from 'react';
import {
    Box, Typography, FormGroup, FormControlLabel, Button, Stack, Checkbox
} from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';
import CustomTextField from 'src/components/forms/theme-elements/CustomTextField';
import axios from 'axios';
import bcrypt from 'bcryptjs'; // bcrypt 추가

const AuthLogin = ({ title, subtitle, subtext }) => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        id: '',
        password: '',
    });

    const handleCheckId = async () => {
        try {
            const res = await axios.get(`/checkId?id=${formData.id}`);
            if (res.data === true) {
                alert('중복된 ID가 있습니다.');
            } else {
                alert('사용 가능한 ID입니다.');
            }
        } catch (e) {
            console.error(e);
            alert('중복 확인에 실패하였습니다.');
        }
    };

    const handleSubmit = async () => {
        try {
            const res = await axios.get(`/login?id=${formData.id}`, {
                withCredentials: true // 쿠키를 전달할 수 있도록 설정
            });
            console.log('**res::', res.data)
            if (res.data.length === 0) {
                throw new Error('Login failed');
            }
            console.log('26번째 줄')
            const hashedPassword = res.data.password; // 데이터베이스에서 해싱된 비밀번호 가져오기
            console.log(hashedPassword)
            console.log('28번째 줄')
            const isMatch = await bcrypt.compare(formData.password, hashedPassword); // 입력받은 비밀번호와 비교
            if (!isMatch) {
                throw new Error('Login failed');
            }
            alert(`${res.adminId}님 환영합니다! 메인페이지로 이동합니다`)
            navigate('/');
        } catch (e) {
            // console.error(e);
            console.log('로그인 실패')
            alert('로그인에 실패하였습니다.');
        }
    };

    const handleChange = (event) => {
        setFormData({
            ...formData,
            [event.target.name]: event.target.value,
        });
    };

    return (
        <>
            {title ? (
                <Typography fontWeight="700" variant="h2" mb={1}>
                    {title}
                </Typography>
            ) : null}
            {subtext}

            <Stack>
                <Box>
                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="id" mb="5px">
                        ID
                    </Typography>
                    <CustomTextField id="id" name="id" variant="outlined" fullWidth onChange={handleChange} />
                    <Button variant="contained" color="primary" onClick={handleCheckId} sx={{ mt: '10px' }}>
                        중복확인
                    </Button>
                    </Box>
                <Box mt="25px">
                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="password" mb="5px">
                        Password
                    </Typography>
                    <CustomTextField id="password" name="password" type="password" variant="outlined" fullWidth onChange={handleChange} />
                </Box>
                <Stack justifyContent="space-between" direction="row" alignItems="center" my={2}>
                    <Typography
                        component={Link}
                        to="/"
                        fontWeight="500"
                        sx={{
                            textDecoration: 'none',
                            color: 'primary.main',
                        }}
                    >
                        Forgot Password ?
                    </Typography>
                </Stack>
            </Stack>
            <Box>
                <Button color="primary" variant="contained" size="large" fullWidth onClick={handleSubmit} type="submit">
                    Sign In
                </Button>
            </Box>
            {subtitle}
        </>
    );
};

export default AuthLogin;

