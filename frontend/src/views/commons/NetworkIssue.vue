<template>
  <div>
    <h1>Oops!</h1>
    <h3>
      O site está fora do ar. Entre em contato com o administrador!
    </h3>
    <router-link :to="{ name: 'Home' }"
      >Voltar para a página inicial</router-link
    >
  </div>
</template>

<script>
export default {
  name: 'NetworkIssue'
}
</script>
