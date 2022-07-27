<template>
  <div>
    <h1>Oops!</h1>
    <h3>A página que você está procurando não foi encontrada!</h3>
    <router-link :to="{ name: 'Home' }"
      >Voltar para a página inicial</router-link
    >
  </div>
</template>

<script>
export default {
  name: 'NotFound'
}
</script>
